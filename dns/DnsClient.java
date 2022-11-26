import java.io.*;
import java.net.*;

class DnsClient {

    public static void main(String args[]) throws Exception {
        DatagramSocket client = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("localhost");
        byte[] sendbyte = new byte[1024];
        byte[] receivebyte = new byte[1024];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter DOMAIN NAME to obtain IP address: ");
        String str = in.readLine();
        sendbyte = str.getBytes();
        DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, 1309);
        client.send(sender);
        DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
        client.receive(receiver);
        String s = new String(receiver.getData());
        System.out.println("IP adddress of DOMAIN NAME :" + s.trim() + "\n");
        client.close();
    }
}
