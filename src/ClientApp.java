import client.ClientNotification;
import client.ClientNotificationImp;
import server.NotificationServer;

import java.rmi.Naming;

public class ClientApp {
    public static void main(String[] args) throws Exception {
        String username = args.length > 0 ? args[0] : "User" + System.currentTimeMillis();

        ClientNotificationImp client = new ClientNotificationImp(username);
        NotificationServer server = (NotificationServer) Naming.lookup("rmi://localhost/notifyServer");

        server.subscribe("sport", client);

        System.out.println("🟢 " + username + " est connecté et abonné au canal 'general'");

    }
}
