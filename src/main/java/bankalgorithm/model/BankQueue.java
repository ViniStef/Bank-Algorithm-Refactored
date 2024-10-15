package main.java.bankalgorithm.model;

import java.util.ArrayList;
import java.util.List;

public class BankQueue {
    List<Client> clients = new ArrayList<>();

    public BankQueue() {

    }

    public Client getFirstInQueue() {
        return clients.getFirst();
    }

    public void addToQueue(Client client) {
        System.out.println("Client added to the queue " + client);
        clients.add(client);
    }

    public void removeFromQueue(Client client) {
        clients.remove(client);
    }

    public boolean isQueueEmpty() {
       return clients.isEmpty();
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "clients=" + clients +
                '}';
    }
}
