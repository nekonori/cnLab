
// to execute run the following command
// javac -cp ".;javax.mail.jar;activation-1.1.1.jar" Pop3.java && java -cp ".;javax.mail.jar;activation-1.1.1.jar" Pop3
import java.util.Properties;
import javax.mail.*;

public class Pop3 {

    public static void main(String[] args) throws Exception {
        Properties props = System.getProperties();
        props.put("mail.pop3.host", "pop.gmail.com");
        props.put("mail.pop3.port", "995");
        props.put("mail.pop3.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props);

        Store store = session.getStore("pop3s");
        String hostname = "pop.gmail.com",
                username = "abc@gmail.com",
                password = "password123";
        store.connect(hostname, username, password);

        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        Message[] messages = folder.getMessages();
        int recent = messages.length - 1;

        Message recentMessage = messages[recent];
        recentMessage.writeTo(System.out);

        folder.close();
        store.close();
    }
}