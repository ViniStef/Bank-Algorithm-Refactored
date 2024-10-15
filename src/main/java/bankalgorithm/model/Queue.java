package main.java.bankalgorithm.model;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    List<Client> clients = new ArrayList<>();

    public Queue() {

    }

    public void addToQueue(Client client) {
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
