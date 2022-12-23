import java.net.*;
import java.io.*;
import java.math.BigInteger;

public class Client {
    static DatagramSocket ds;
    static DatagramPacket sp;
    static InetAddress ipaddr;
    static byte[] send = new byte[1024];

    static void sendFile(String filePath, String fileName) throws Exception {
        System.out.println(filePath + fileName);

        File f = new File(filePath + fileName);
        FileInputStream fis = new FileInputStream(f);
        send = String.valueOf(f.length()).getBytes();
        sp = new DatagramPacket(send, send.length, ipaddr, 5000);
        System.out.println(f.length());
        ds.send(sp);
        send = fileName.getBytes();
        sp = new DatagramPacket(send, send.length, ipaddr, 5000);
        ds.send(sp);

        send = new byte[1024];
        int bytes = 0;
        System.out.println("Prepariing to send");
        while ((bytes = fis.read(send)) != -1) {
            sp = new DatagramPacket(send, send.length, ipaddr, 5000);
            ds.send(sp);
            System.out.println("sent " + send.length);
            send = new byte[1024];

        }

        fis.close();
        System.out.println("sent file");
    }

    public static void main(String[] args) throws Exception {
        try {
            ds = new DatagramSocket(4000);

            String fp = "F:\\Java-Programs\\Networking\\";
            ipaddr = InetAddress.getByName("localhost");
            String filename = "newtig.jpeg";

            sendFile(fp, filename);
            System.out.println("Sending file to server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}