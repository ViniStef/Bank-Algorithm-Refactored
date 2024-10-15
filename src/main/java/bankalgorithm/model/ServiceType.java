package main.java.bankalgorithm.model;

public enum ServiceType {
    WITHDRAW(60),
    DEPOSIT(90),
    PAYMENT(120);

    final int serviceValue;

    ServiceType(int currentServiceValue) {
        serviceValue = currentServiceValue;
    }

}
