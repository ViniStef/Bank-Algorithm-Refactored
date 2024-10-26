package main.java.bankalgorithm.services.implementations;

import main.java.bankalgorithm.models.Client;
import main.java.bankalgorithm.models.ServiceCounter;

import java.util.Arrays;

public class ServiceCounterGroup {
    private ServiceCounter[] serviceCounters;

    public ServiceCounterGroup(ServiceCounter[] serviceCounters) {
        this.serviceCounters = serviceCounters;
    }

    public ServiceCounter[] getServiceCounters() {
        return this.serviceCounters;
    }

    public int getEarliestCounterAvailableTime() {
        int earliestAvailableCounter = serviceCounters[0].getServiceAvailableAt();

        for (ServiceCounter serviceCounter : serviceCounters) {
            if (serviceCounter.getServiceAvailableAt() == 0) {
                return 0;
            }
            if (serviceCounter.getServiceAvailableAt() < earliestAvailableCounter) {
                earliestAvailableCounter = serviceCounter.getServiceAvailableAt();
            }
        }
        return earliestAvailableCounter;
    }

    public void resetServiceAtTime(int currentTime) {
        for (ServiceCounter serviceCounter : serviceCounters) {
            if (serviceCounter.getServiceAvailableAt() == currentTime) {
                serviceCounter.makeServiceAvailable();
            }
        }
    }

    public boolean addClientToCounter(int currentTime, Client client) {
        int willBeFreeAt = currentTime + client.getServiceType().serviceValue;
        for (ServiceCounter serviceCounter : serviceCounters) {
            if (serviceCounter.getServiceAvailableAt() == 0) {
                System.out.println("Added client to the counter " + client);
                serviceCounter.setServiceAvailableAt(willBeFreeAt);
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "ServiceCounterGroup{" +
                "serviceCounters=" + Arrays.toString(serviceCounters) +
                '}';
    }
}
