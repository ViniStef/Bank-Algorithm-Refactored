package main.java.bankalgorithm.services.implementations;

import main.java.bankalgorithm.models.Client;
import main.java.bankalgorithm.services.interfaces.IQueue;

import java.util.ArrayList;
import java.util.List;

public class BankQueue implements IQueue {
    private double totalQueueTime = 0;
    private int totalClientsHadInQueue = 0;
    List<Client> clients = new ArrayList<>();

    public void increaseTotalClientsHadInQueue() {
        this.totalClientsHadInQueue++;
    }

    @Override
    public Client getFirstInQueue() {
        return clients.getFirst();
    }

    @Override
    public void addToQueue(Client client) {
        System.out.println("Client added to the queue " + client);
        increaseTotalClientsHadInQueue();
        clients.add(client);
    }

    @Override
    public void removeFromQueue(Client client) {
        clients.remove(client);
    }

    @Override
    public void calculateQueueWaitTime(Client client, int currentTime) {
        this.totalQueueTime = this.totalQueueTime + (currentTime - client.getArrivedTime());
    }

    @Override
    public boolean isEmpty() {
       return clients.isEmpty();
    }

    @Override
    public double calculateAverageQueueTime() {
        return this.totalQueueTime / this.totalClientsHadInQueue;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public int getTotalClientsHadInQueue() {
        return totalClientsHadInQueue;
    }

    public double getTotalQueueTime() {
        return totalQueueTime;
    }

    public void setTotalQueueTime(double totalQueueTime) {
        this.totalQueueTime = totalQueueTime;
    }

    @Override
    public String toString() {
        return "BankQueue{" +
                "totalQueueTime=" + totalQueueTime +
                ", totalClientsHadInQueue=" + totalClientsHadInQueue +
                ", clients=" + clients +
                '}';
    }
}
