package main.java.bankalgorithm.model;

import java.util.Random;

public class GenerateClient {
    private int min = 0;
    private int max = 29;

    public GenerateClient() {
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public Client tryGeneratingClient(int currentTime) {
        Random random = new Random();
        int randomNumber = random.nextInt(0, 30);
        if (randomNumber == 0) {
            return new Client(currentTime, ServiceType.generateRandomService());
        }

        return null;
    }
}
