package test.java.bankalgorithm.test;

import main.java.bankalgorithm.model.ServiceCounter;
import main.java.bankalgorithm.model.ServiceCounterGroup;

public class ServiceCounterTest01 {
    public static void main(String[] args) {
        ServiceCounter counter1 = new ServiceCounter();
        ServiceCounter counter2 = new ServiceCounter();
        ServiceCounter counter3 = new ServiceCounter();

        ServiceCounter[] counterGroup =
                new ServiceCounter[]{counter1, counter2, counter3};

        ServiceCounterGroup serviceCounterGroup = new ServiceCounterGroup(counterGroup);

        counter1.setServiceAvailableAt(65);
        counter2.setServiceAvailableAt(86);

        if (serviceCounterGroup.getEarliestCounterAvailableTime() == 0) {
//            serviceCounterGroup.addClientToCounter(60, 123);
            System.out.println("Added client to counter successfully.");
        } else {
            System.out.println("No counters available at this moment.");
        }

        System.out.println(serviceCounterGroup);
    }
}
