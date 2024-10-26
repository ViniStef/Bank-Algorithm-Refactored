package main.java.bankalgorithm.services.implementations;

import main.java.bankalgorithm.models.Client;
import main.java.bankalgorithm.models.ServiceDesk;

public class BankWorkShift {
    private int workShiftSeconds;
    private int currentSecond = 1;
    private int nextAvailableCounter = 0;
    private int totalClients = 0;
    private ServiceDeskGroup serviceDeskGroup;
    private BankQueue bankQueue;

    public BankWorkShift(int workShiftSeconds, ServiceDeskGroup serviceDeskGroup, BankQueue bankQueue) {
        this.workShiftSeconds = workShiftSeconds;
        this.serviceDeskGroup = serviceDeskGroup;
        this.bankQueue = bankQueue;
    }

    public void handleTimeMatchesAvailableDesk() {
        this.serviceDeskGroup.resetServiceAtTime(this.currentSecond);
        if (!bankQueue.isEmpty()) {
            this.serviceDeskGroup.addClientToDesk(this.currentSecond, this.bankQueue.getFirstInQueue());
            this.bankQueue.calculateQueueWaitTime(this.bankQueue.getFirstInQueue(), this.currentSecond);
            this.bankQueue.removeFromQueue(this.bankQueue.getFirstInQueue());
        }
        this.nextAvailableCounter = this.serviceDeskGroup.getEarliestDeskAvailableTime();
    }

    public void handleCreatedClient(Client client) {
        if (this.currentSecond >= this.nextAvailableCounter) {
            boolean isAdded = this.serviceDeskGroup.addClientToDesk(this.currentSecond, client);
            if (!isAdded) {
                this.bankQueue.addToQueue(client);
            }
            this.nextAvailableCounter = this.serviceDeskGroup.getEarliestDeskAvailableTime();
        } else {
            this.bankQueue.addToQueue(client);
        }
    }

    public void executeWorkShift(GenerateClient generateClient, ServiceDesk[] deskGroup) {
        while (this.currentSecond <= this.workShiftSeconds) {
            if (nextAvailableCounter == this.currentSecond || nextAvailableCounter == 0) {
                handleTimeMatchesAvailableDesk();
            }
            Client client = generateClient.tryGeneratingClient(this.currentSecond);
            if (client != null) {
                this.totalClients++;
                handleCreatedClient(client);
            }

            this.currentSecond++;
        }
        System.out.println(this.bankQueue.calculateAverageQueueTime());
        System.out.println(this.totalClients);
    };

    public int getWorkShiftSeconds() {
        return workShiftSeconds;
    }

    public void setWorkShiftSeconds(int workShiftSeconds) {
        this.workShiftSeconds = workShiftSeconds;
    }

    public int getCurrentSecond() {
        return currentSecond;
    }

    public void setCurrentSecond(int currentSecond) {
        this.currentSecond = currentSecond;
    }

    public int getNextAvailableCounter() {
        return nextAvailableCounter;
    }

    public int getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(int totalClients) {
        this.totalClients = totalClients;
    }

    public ServiceDeskGroup getServiceDeskGroup() {
        return serviceDeskGroup;
    }

    public BankQueue getBankQueue() {
        return bankQueue;
    }

    @Override
    public String toString() {
        return "BankWorkShift{" +
                "workShiftSeconds=" + workShiftSeconds +
                ", currentSecond=" + currentSecond +
                ", nextAvailableCounter=" + nextAvailableCounter +
                ", totalClients=" + totalClients +
                ", serviceDeskGroup=" + serviceDeskGroup +
                ", bankQueue=" + bankQueue +
                '}';
    }

}
