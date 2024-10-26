package main.java.bankalgorithm.services.interfaces;

import main.java.bankalgorithm.models.Client;

public interface IQueue {
    Client getFirstInQueue();

    void addToQueue(Client client);

    void removeFromQueue(Client client);

    void calculateQueueWaitTime(Client client, int currentTime);

    double calculateAverageQueueTime();

    boolean isEmpty();
}
