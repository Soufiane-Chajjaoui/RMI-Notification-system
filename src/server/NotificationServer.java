package server;

import client.ClientNotification;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NotificationServer extends Remote {
    void subscribe(String channel,ClientNotification notification) throws RemoteException;
    void unsubscribe(String channel,ClientNotification notification) throws RemoteException;
    void sendToChannel(String channel,String message) throws RemoteException;
}
