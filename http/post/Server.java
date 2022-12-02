import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    static void getReq(String urlString, String data, PrintWriter clientOut) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.getOutputStream().write(data.getBytes());
        int responseCode = con.getResponseCode();
        clientOut.println("Response code - " + responseCode + "\n");
        if (responseCode == HttpURLConnection.HTTP_OK) {
            Scanner responseIn = new Scanner(new InputStreamReader(con.getInputStream()));
            while (responseIn.hasNextLine()) {
                clientOut.println(responseIn.nextLine());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5050);
        Socket client = ss.accept();
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        Scanner in = new Scanner(new InputStreamReader(client.getInputStream()));
        String url = in.next(),
                data = in.next();
        getReq(url, data, out);
        ss.close();
    }
}
