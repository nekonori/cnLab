import java.net.*;
import java.util.*;

class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket dsclient = new DatagramSocket();
        InetAddress ipaddr = InetAddress.getByName("localhost");
        Scanner in = new Scanner(System.in);
        byte[] senddata = new byte[1024];
        byte[] recdata = new byte[1024];
        while (true) {
            System.out.print("Enter Msg to server-->");
            String tosend = in.nextLine();
            senddata = tosend.getBytes();
            DatagramPacket sendpacket = new DatagramPacket(senddata, senddata.length, ipaddr, 5000);
            dsclient.send(sendpacket);
            if (tosend.equalsIgnoreCase("bye"))
                break;
            DatagramPacket recpacket = new DatagramPacket(recdata, recdata.length);
            dsclient.receive(recpacket);
            String rec_frm_ser = new String(recpacket.getData());
            System.out.println("Msg from server: " + rec_frm_ser);
        }
        dsclient.close();
        in.close();
    }
}