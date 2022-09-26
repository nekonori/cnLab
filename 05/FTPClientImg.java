package ftp;

import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class FTPClientImg {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        InputStream inputStream = socket.getInputStream();
        BufferedImage image = ImageIO.read(inputStream);
        ImageIO.write(image, "png", new File("E:\\3902\\new\\res.png"));
        socket.close();
    }
}
