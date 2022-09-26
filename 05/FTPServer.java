package ftp;

import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class FTPServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
//        beta begin
        OutputStream w = socket.getOutputStream();
        BufferedImage image = ImageIO.read(new File("E:\\3902\\old\\flower.jpg"));
        ImageIO.write(image, "jpg", w);
//        beta end
//        InputStream inputStream = socket.getInputStream();
//        BufferedImage image = ImageIO.read(inputStream);
//        ImageIO.write(image, "jpg", new File("E:\\3902\\new\\result.jpg"));
        serverSocket.close();
    }
}
