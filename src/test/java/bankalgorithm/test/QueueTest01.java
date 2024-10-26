package test.java.bankalgorithm.test;

import main.java.bankalgorithm.models.*;
import main.java.bankalgorithm.models.enums.ServiceType;
import main.java.bankalgorithm.services.implementations.BankQueue;
import main.java.bankalgorithm.services.implementations.ServiceDeskGroup;

public class QueueTest01 {
    public static void main(String[] args) {
        ServiceDesk counter1 = new ServiceDesk();
        ServiceDesk counter2 = new ServiceDesk();
        ServiceDesk counter3 = new ServiceDesk();

        ServiceDesk[] counterGroup =
                new ServiceDesk[]{counter1, counter2, counter3};

        ServiceDeskGroup serviceDeskGroup = new ServiceDeskGroup(counterGroup);

        counter1.setServiceAvailableAt(65);
        counter2.setServiceAvailableAt(86);
        counter3.setServiceAvailableAt(90);

        BankQueue bankQueue = new BankQueue();

        Client client1 = new Client(54, ServiceType.DEPOSIT);
        Client client2 = new Client(78, ServiceType.WITHDRAW);
        Client client3 = new Client(95, ServiceType.PAYMENT);

        if (serviceDeskGroup.getEarliestDeskAvailableTime() == 0) {
//            serviceDeskGroup.addClientToCounter(60, 123);
            System.out.println("Added client to counter successfully.");
        } else {
            bankQueue.addToQueue(client1);
            System.out.println("Added client to queue successfully.");
            bankQueue.addToQueue(client2);
            System.out.println("Added client to queue successfully.");
            bankQueue.addToQueue(client3);
            System.out.println("Added client to queue successfully.");
        }

        System.out.println(serviceDeskGroup);
        System.out.println(bankQueue);
    }
}
