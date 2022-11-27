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
        String url = sc.next();
        out.println(url);
        String res = in.nextLine();
        System.out.println("GET Resoponse:\n" + res);
        clientSocket.close();
    }
}