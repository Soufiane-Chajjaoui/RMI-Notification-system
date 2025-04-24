import server.NotificationServer;

import java.rmi.Naming;

public class BatchTrigger {
    public static void main(String[] args) throws Exception {
        NotificationServer server = (NotificationServer) Naming.lookup("rmi://localhost/notifyServer");
        server.sendToChannel("sport", "📢 Ceci est un message batch !");
    }
}
