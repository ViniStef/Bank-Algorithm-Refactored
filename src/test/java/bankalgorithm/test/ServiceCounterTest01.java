package test.java.bankalgorithm.test;

import main.java.bankalgorithm.models.ServiceDesk;
import main.java.bankalgorithm.services.implementations.ServiceDeskGroup;

public class ServiceCounterTest01 {
    public static void main(String[] args) {
        ServiceDesk desk1 = new ServiceDesk();
        ServiceDesk desk2 = new ServiceDesk();
        ServiceDesk desk3 = new ServiceDesk();

        ServiceDesk[] deskGroup =
                new ServiceDesk[]{desk1, desk2, desk3};

        ServiceDeskGroup serviceDeskGroup = new ServiceDeskGroup(deskGroup);

        desk1.setServiceAvailableAt(65);
        desk2.setServiceAvailableAt(86);

        if (serviceDeskGroup.getEarliestDeskAvailableTime() == 0) {
            System.out.println("Added client to desk successfully.");
        } else {
            System.out.println("No desk available at this moment.");
        }

        System.out.println(serviceDeskGroup);
    }
}
