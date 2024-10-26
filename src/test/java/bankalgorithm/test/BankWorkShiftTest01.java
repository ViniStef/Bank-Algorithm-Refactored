package test.java.bankalgorithm.test;

import main.java.bankalgorithm.services.implementations.BankWorkShift;

public class BankWorkShiftTest01 {
    public static void main(String[] args) {
        BankWorkShift bankWorkShift = new BankWorkShift(500);
        bankWorkShift.executeWorkShift();
    }
}
