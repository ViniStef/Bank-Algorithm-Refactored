package main.java.bankalgorithm.models;

import main.java.bankalgorithm.services.interfaces.IQueue;

import java.util.ArrayList;
import java.util.List;

public class BankQueue implements IQueue {
    List<Client> clients = new ArrayList<>();

    @Override
    public Client getFirstInQueue() {
        return clients.getFirst();
    }

    @Override
    public void addToQueue(Client client) {
        System.out.println("Client added to the queue " + client);
        clients.add(client);
    }

    @Override
    public void removeFromQueue(Client client) {
        clients.remove(client);
    }

    @Override
    public boolean isEmpty() {
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
