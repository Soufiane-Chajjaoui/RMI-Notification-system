package client;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ClientNotificationImp extends UnicastRemoteObject implements ClientNotification {

    private final String clientName;

    public ClientNotificationImp(String name) throws RemoteException {
        super();
        this.clientName = name;
    }

    @Override
    public void notify(String channel, String message) throws RemoteException {
        System.out.println("🔔 [" + clientName + "] reçu du canal '" + channel + "' : " + message);
    }
}
