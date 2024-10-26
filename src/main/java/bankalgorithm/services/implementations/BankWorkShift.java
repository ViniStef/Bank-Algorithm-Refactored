package main.java.bankalgorithm.models;

import main.java.bankalgorithm.services.implementations.GenerateClient;

public class BankWorkShift {
    int workShiftSeconds;

    public BankWorkShift(int workShiftSeconds) {
        this.workShiftSeconds = workShiftSeconds;
    }

    public void executeWorkShift() {
        GenerateClient generateClient = new GenerateClient();
        Client client = null;
        BankQueue bankQueue = new BankQueue();
        int currentSecond = 0;
        int nextAvailableCounter = 0;

        ServiceCounter counter1 = new ServiceCounter();
        ServiceCounter counter2 = new ServiceCounter();
        ServiceCounter counter3 = new ServiceCounter();

        ServiceCounter[] counterGroup = new ServiceCounter[]{counter1, counter2, counter3};

        ServiceCounterGroup serviceCounterGroup = new ServiceCounterGroup(counterGroup);

        int totalClients = 0;


        while (currentSecond <= workShiftSeconds) {
            if (nextAvailableCounter == currentSecond || nextAvailableCounter == 0) {
                serviceCounterGroup.resetServiceAtTime(currentSecond);
                if (!bankQueue.isEmpty()) {
                    System.out.println("Current time: " + currentSecond);
                    serviceCounterGroup.addClientToCounter(currentSecond, bankQueue.getFirstInQueue());
                    bankQueue.removeFromQueue(bankQueue.getFirstInQueue());
                }
                nextAvailableCounter = serviceCounterGroup.getEarliestCounterAvailableTime();
            }
            client = generateClient.tryGeneratingClient(currentSecond);
            if (client != null) {
                totalClients++;
                if (currentSecond >= nextAvailableCounter) {
                    System.out.println("Current time: " + currentSecond);
                    boolean isAdded = serviceCounterGroup.addClientToCounter(currentSecond, client);
                    if (!isAdded) {
                        System.out.println("Current time: " + currentSecond);
                        bankQueue.addToQueue(client);

                    }
                    nextAvailableCounter = serviceCounterGroup.getEarliestCounterAvailableTime();
                } else {
                    bankQueue.addToQueue(client);
                }
            }

            currentSecond++;
        }
        System.out.println(totalClients);
    };
}
