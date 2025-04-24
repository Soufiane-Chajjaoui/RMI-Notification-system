package server;

import client.ClientNotification;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class NotificationServerImp extends UnicastRemoteObject implements NotificationServer {

    private final Map<String, List<ClientNotification>> channelSubscriptions = new HashMap<>();

    public NotificationServerImp() throws RemoteException {
        super();
    }

    @Override
    public synchronized void subscribe(String channel, ClientNotification client) throws RemoteException {
        channelSubscriptions.putIfAbsent(channel, new ArrayList<>());
        if (!channelSubscriptions.get(channel).contains(client)) {
            channelSubscriptions.get(channel).add(client);
            System.out.println("🟢 Client abonné au canal : " + channel);
        }
    }

    @Override
    public synchronized void unsubscribe(String channel, ClientNotification client) throws RemoteException {
        List<ClientNotification> clients = channelSubscriptions.get(channel);
        if (clients != null) {
            clients.remove(client);
            System.out.println("🔴 Client désabonné du canal : " + channel);
        }
    }


    @Override
    public synchronized void sendToChannel(String channel, String message) throws RemoteException {
        List<ClientNotification> clients = channelSubscriptions.get(channel);
        if (clients != null) {
            System.out.println("📣 Envoi sur canal [" + channel + "] : " + message);
            Iterator<ClientNotification> iterator = clients.iterator();
            while (iterator.hasNext()) {
                try {
                    iterator.next().notify(channel, message);
                } catch (Exception e) {
                    iterator.remove(); // Supprimer les clients morts
                }
            }
        }
    }
}
