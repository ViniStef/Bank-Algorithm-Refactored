package main.java.bankalgorithm.models;

import java.util.Random;

public enum ServiceType {
    WITHDRAW(60),
    DEPOSIT(90),
    PAYMENT(120);

    final int serviceValue;
    private static final Random random = new Random();

    ServiceType(int currentServiceValue) {
        serviceValue = currentServiceValue;
    }

    public static ServiceType generateRandomService() {
        int randomNum = random.nextInt(1, 4);
        return switch (randomNum) {
            case 1 -> WITHDRAW;
            case 2 -> DEPOSIT;
            case 3 -> PAYMENT;
            default -> null;
        };
    }
}
