import java.io.*;
import java.net.*;

public class Server {
    private static DataOutputStream dos;
    private static DataInputStream dis;

    public static void main(String[] args) {
        ServerSocket ss = new ServerSocket(5050);
        Socket client = ss.accept();
        dos = new DataOutputStream(client.getOutputStream());
        dis = new DataInputStream(client.getInputStream());
        String fileName = dis.readUTF();
        long fileSize = dis.readLong();
        receiveFile(fileName, fileSize);
        dis.close();
        dos.close();
        ss.close();
    }

    static void receiveFile(String fileName, long fileSize){
        int bytes = 0;
        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = new byte[4 * 1024];
        int bytes = 0;
        while (fileSize > 0 && (bytes = dis.read(fos, 0, bytes)))
    }
}
