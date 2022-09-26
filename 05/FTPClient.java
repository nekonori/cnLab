package ftp;

import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class FTPClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        InputStream inputStream = socket.getInputStream();
        BufferedImage image = ImageIO.read(inputStream);
        ImageIO.write(image, "jpg", new File("E:\\3902\\new\\res.jpg"));
//        OutputStream outputStream = socket.getOutputStream();
//        BufferedImage image = ImageIO.read(new File("E:\\3902\\old\\test.png"));
//        ImageIO.write(image, "test", outputStream);
        socket.close();
    }
}
