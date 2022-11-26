import java.io.*;
import java.net.*;

public class Server {
    private static DataOutputStream dos;
    private static DataInputStream dis;

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5050);
        Socket client = ss.accept();
        System.out.println("Connected to client");
        dos = new DataOutputStream(client.getOutputStream());
        dis = new DataInputStream(client.getInputStream());
        long fileSize = dis.readLong();
        String fileName = dis.readUTF();
        receiveFile(fileName, fileSize);
        dis.close();
        dos.close();
        ss.close();
    }

    static void receiveFile(String fileName, long fileSize) throws Exception {
        int bytes = 0;
        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = new byte[4 * 1024];
        while (fileSize > 0 &&
                (bytes = dis.read(
                        buffer, 0,
                        (int) Math.min(buffer.length, fileSize))) != 1) {
            fos.write(buffer, 0, bytes);
            fileSize -= bytes;
        }
        System.out.println("Received " + fileName);
        fos.close();
    }
}
