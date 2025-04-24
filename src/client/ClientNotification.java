package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientNotification extends Remote {
    void notify(String channel, String message) throws RemoteException;
}
