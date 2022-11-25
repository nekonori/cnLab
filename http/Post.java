import java.net.*;
import com.sun.net.httpserver.*;

public class Post {
    final static int PORT = 5050;

    public static void main(String[] args) throws Exception {
        var httpServer = HttpServer.create(new InetSocketAddress(5050), 0);
        var homeContext = httpServer.createContext("/");
        homeContext.setHandler(httpExchange -> {
            // prints the url requested and method (E.g. GET /)
            System.out.println(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());

            Headers requestHeaders = httpExchange.getRequestHeaders();
            int contentLength = Integer.parseInt(requestHeaders.getFirst("Content-length"));

            // get form data from post request body
            var is = httpExchange.getRequestBody();
            byte[] data = new byte[contentLength];
            is.read(data);

            System.out.println("POST form data:");
            System.out.println(new String(data));

            httpExchange.close();
        });

        httpServer.start();
        System.out.println("Server listening on port " + PORT);
    }
}
