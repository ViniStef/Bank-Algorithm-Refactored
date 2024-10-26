package main.java.bankalgorithm.services.implementations;

import main.java.bankalgorithm.models.Client;
import main.java.bankalgorithm.models.ServiceDesk;
import main.java.bankalgorithm.services.interfaces.IServiceDeskGroup;

import java.util.Arrays;

public class ServiceDeskGroup implements IServiceDeskGroup {
    private ServiceDesk[] serviceDesks;

    public ServiceDeskGroup(ServiceDesk[] serviceDesks) {
        this.serviceDesks = serviceDesks;
    }

    public ServiceDesk[] getServiceDesks() {
        return this.serviceDesks;
    }

    @Override
    public int getEarliestDeskAvailableTime() {
        int earliestAvailableDesk = serviceDesks[0].getServiceAvailableAt();

        for (ServiceDesk serviceDesk : serviceDesks) {
            if (serviceDesk.getServiceAvailableAt() == 0) {
                return 0;
            }
            if (serviceDesk.getServiceAvailableAt() < earliestAvailableDesk) {
                earliestAvailableDesk = serviceDesk.getServiceAvailableAt();
            }
        }
        return earliestAvailableDesk;
    }

    @Override
    public void resetServiceAtTime(int currentTime) {
        for (ServiceDesk serviceDesk : serviceDesks) {
            if (serviceDesk.getServiceAvailableAt() == currentTime) {
                serviceDesk.makeServiceAvailable();
            }
        }
    }

    @Override
    public boolean addClientToDesk(int currentTime, Client client) {
        int willBeFreeAt = currentTime + client.getServiceType().serviceValue;
        for (ServiceDesk serviceDesk : serviceDesks) {
            if (serviceDesk.getServiceAvailableAt() == 0) {
                System.out.println("Added client to the counter " + client);
                serviceDesk.setServiceAvailableAt(willBeFreeAt);
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "ServiceDeskGroup{" +
                "serviceDesks=" + Arrays.toString(serviceDesks) +
                '}';
    }
}
