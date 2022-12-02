import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Socket clientSocket = new Socket("localhost", 5050);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        Scanner in = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
        System.out.print("URL>>");
        String url = sc.nextLine();
        out.println(url);
        System.out.println("Enter POST data seperated by '&'\nE.g. 'name=alice&age=12'");
        System.out.print("POST data>>");
        String postData = sc.nextLine();
        out.println(postData);
        String resCode = in.nextLine();
        System.out.println(resCode);
        while (in.hasNextLine())
            System.out.println(in.nextLine());
        clientSocket.close();
    }
}