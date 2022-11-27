import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5050);
        System.out.println("Server listening on port 5050");
        Socket client = ss.accept();
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        Scanner in = new Scanner(new InputStreamReader(client.getInputStream()));
        out.println("Connected to server");
        System.out.println("Client connected");
        String address = in.next();
        int packets = in.nextInt();
        System.out.println("Executing ping");
        out.println("Pinging " + address + " with " + packets + " packets");
        Process p = Runtime.getRuntime().exec(new String[] { "ping ", address, "/n", String.valueOf(packets) });
        Scanner pingInput = new Scanner(new InputStreamReader(p.getInputStream()));
        while (pingInput.hasNextLine()) {
            out.println(pingInput.nextLine());
        }
        ss.close();
        out.println("END");
        out.close();
        in.close();
    }
}