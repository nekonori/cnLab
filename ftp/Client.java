import java.net.*;
import java.io.*;

public class Client {
    static DataOutputStream dos;
    static DataInputStream dis;

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5050);
        dos = new DataOutputStream(s.getOutputStream());
        dis = new DataInputStream(s.getInputStream());
        String filePath = "D:\\Temp\\old\\", fileName = "cap.pdf";
        System.out.println("Sending file to server");
        sendFile(filePath, fileName);
        System.out.println("File sent successfully");
        dis.close();
        dos.close();
        s.close();
    }

    static void sendFile(String filePath, String fileName) throws Exception {
        File f = new File(filePath + fileName);
        FileInputStream fis = new FileInputStream(f);
        dos.writeLong(f.length());
        dos.writeUTF(fileName);
        byte[] buffer = new byte[4 * 1024];
        int bytes = 0;
        while ((bytes = fis.read(buffer)) != -1) {
            dos.write(buffer, 0, bytes);
            dos.flush();
        }
        fis.close();
    };
};
