
import java.io.*;
import java.net.*;
import java.util.*;

class DNSServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket server = new DatagramSocket(1309);
        while (true) {
            int flag = 0;
            byte[] sendbyte = new byte[1024];
            byte[] receivebyte = new byte[1024];
            DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
            server.receive(receiver);
            String str = new String(receiver.getData());
            String s = str.trim();
            InetAddress addr = receiver.getAddress();
            int port = receiver.getPort();    
            sendbyte = InetAddress.getByName(s).toString().getBytes();
            DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
            server.send(sender); break;
        }
        server.close();
    }
}
