import server.NotificationServerImp;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099); // Lancer le registre RMI
        NotificationServerImp server = new NotificationServerImp();
        Naming.rebind("rmi://localhost/notifyServer", server);
        System.out.println("✅ Serveur de notification en ligne...");
    }
}
