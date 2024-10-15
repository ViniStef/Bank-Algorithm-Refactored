package test.java.bankalgorithm.test;

import main.java.bankalgorithm.model.*;

public class QueueTest01 {
    public static void main(String[] args) {
        ServiceCounter counter1 = new ServiceCounter();
        ServiceCounter counter2 = new ServiceCounter();
        ServiceCounter counter3 = new ServiceCounter();

        ServiceCounter[] counterGroup =
                new ServiceCounter[]{counter1, counter2, counter3};

        ServiceCounterGroup serviceCounterGroup = new ServiceCounterGroup(counterGroup);

        counter1.setServiceAvailableAt(65);
        counter2.setServiceAvailableAt(86);
        counter3.setServiceAvailableAt(90);

        Queue queue = new Queue();

        Client client1 = new Client(54, ServiceType.DEPOSIT);
        Client client2 = new Client(78, ServiceType.WITHDRAW);
        Client client3 = new Client(95, ServiceType.PAYMENT);

        if (serviceCounterGroup.getEarliestCounterAvailableTime() == 0) {
            serviceCounterGroup.addClientToCounter(60, 123);
            System.out.println("Added client to counter successfully.");
        } else {
            queue.addToQueue(client1);
            System.out.println("Added client to queue successfully.");
            queue.addToQueue(client2);
            System.out.println("Added client to queue successfully.");
            queue.addToQueue(client3);
            System.out.println("Added client to queue successfully.");
        }

        System.out.println(serviceCounterGroup);
        System.out.println(queue);
    }
}
