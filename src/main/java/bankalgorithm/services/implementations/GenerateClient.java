package main.java.bankalgorithm.models;

import main.java.bankalgorithm.models.enums.ServiceType;
import main.java.bankalgorithm.services.interfaces.IGenerateClient;

import java.util.Random;

public class GenerateClient implements IGenerateClient {
    private final int min;
    private final int max;
    private final Random random;

    public GenerateClient(int min, int max) {
        this.min = min;
        this.max = max;
        this.random = new Random();
    }

    public GenerateClient() {
        this(0, 30);
    }

    @Override
    public Client tryGeneratingClient(int currentTime) {
        int randomNumber = random.nextInt(min, max);
        if (randomNumber == 0) {
            return new Client(currentTime, ServiceType.generateRandomService());
        }

        return null;
    }
}
