package ftp;

import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class FTPServerImg {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        OutputStream w = socket.getOutputStream();
        BufferedImage image = ImageIO.read(new File("E:\\3902\\old\\test.png"));
        ImageIO.write(image, "png", w);
        serverSocket.close();
    }
}
