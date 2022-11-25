// visit http://localhost:5050 on your browser to preview

import java.net.*;
import com.sun.net.httpserver.*;

public class Get {
    final static int PORT = 5050;

    public static void main(String[] args) throws Exception {
        var httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        var homeContext = httpServer.createContext("/");
        homeContext.setHandler(httpExchange -> {
            // prints the url requested and method (E.g. GET /)
            System.out.println(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
            String htmlResponse = "<h1>Hello world!</h1>";
            httpExchange.sendResponseHeaders(200, htmlResponse.length());
            var outputStream = httpExchange.getResponseBody();
            outputStream.write(htmlResponse.getBytes());
            httpExchange.close();
        });
        httpServer.start();
        System.out.println("Server listening on port " + PORT);
    }
}