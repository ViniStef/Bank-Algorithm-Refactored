package main.java.bankalgorithm.model;

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

        while (currentSecond <= workShiftSeconds) {
            client = generateClient.tryGeneratingClient(currentSecond);
            if (client != null) {
                if (currentSecond >= nextAvailableCounter) {
                    boolean isAdded = serviceCounterGroup.addClientToCounter(currentSecond, client);
                    if (!isAdded) {
                        bankQueue.addToQueue(client);
                    }
                }
            }

            currentSecond++;
        }
    };
}
