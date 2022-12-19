import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;

public class Server {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("index.html");
        var httpServer = HttpServer.create(new InetSocketAddress(5050), 0);
        var homeContext = httpServer.createContext("/");
        homeContext.setHandler(exchange -> {
            System.out.println(exchange.getRequestMethod() + " " + exchange.getRequestURI());
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = fis.read()) != -1) {
                sb.append((char) c);
            }
            fis.close();
            String responseHTML = sb.toString();
            exchange.sendResponseHeaders(200, responseHTML.length());
            OutputStream out = exchange.getResponseBody();
            out.write(responseHTML.getBytes());
            exchange.close();
        });
        httpServer.start();
        System.out.println("Server listening on port 5050");
    }
}
