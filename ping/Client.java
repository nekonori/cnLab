import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5050);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        Scanner in = new Scanner(new InputStreamReader(s.getInputStream()));
        Scanner terminalIn = new Scanner(System.in);
        System.out.println(in.nextLine());
        System.out.print("Address to ping >>");
        String address = terminalIn.next();
        System.out.print("No. of packets to send >>");
        int packets = terminalIn.nextInt();
        out.println(address);
        out.println(packets);
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
        s.close();
        out.close();
        in.close();
        terminalIn.close();
    }
}
