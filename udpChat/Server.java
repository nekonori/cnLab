import java.net.*;
import java.util.*;

class Server {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DatagramSocket dsserver = new DatagramSocket(5000);
        byte[] sendata = new byte[1024];
        byte[] recdata = new byte[1024];
        while (true) {
            recdata = new byte[1024];
            DatagramPacket recpacket = new DatagramPacket(recdata, recdata.length);
            dsserver.receive(recpacket);
            String clismsg = new String(recpacket.getData());
            clismsg = clismsg.replace("\0", "");
            if (clismsg.equalsIgnoreCase("bye")) {
                break;
            }
            InetAddress ipaddr = recpacket.getAddress();
            int port = recpacket.getPort();
            System.out.println("Msg from client: " + clismsg);
            System.out.print("Enter msg to Client-->");
            String cli = sc.nextLine();
            sendata = cli.getBytes();
            DatagramPacket sendpacket = new DatagramPacket(sendata, sendata.length, ipaddr, port);
            dsserver.send(sendpacket);
        }
        dsserver.close();
        sc.close();
    }
}