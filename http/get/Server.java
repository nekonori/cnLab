import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    static String getReq(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        int responseCode = con.getResponseCode();
        System.out.println("Response code: " + responseCode);
        StringBuilder res = new StringBuilder();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            Scanner in = new Scanner(new InputStreamReader(con.getInputStream()));
            while (in.hasNextLine())
                res.append(in.nextLine());
        }
        return res.toString();
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5050);
        Socket client = ss.accept();
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        Scanner in = new Scanner(new InputStreamReader(client.getInputStream()));
        String url = in.next();
        System.out.println(url);
        out.println(getReq(url));
        ss.close();
    }
}
