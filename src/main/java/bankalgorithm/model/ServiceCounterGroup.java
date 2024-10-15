package main.java.bankalgorithm.model;

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

    public void addClientToCounter(int currentTime, int actionTime) {
        int willBeFreeAt = currentTime + actionTime;
        for (ServiceCounter serviceCounter : serviceCounters) {
            if (serviceCounter.getServiceAvailableAt() == 0) {
                serviceCounter.setServiceAvailableAt(willBeFreeAt);
            }
        }
    }

    @Override
    public String toString() {
        return "ServiceCounterGroup{" +
                "serviceCounters=" + Arrays.toString(serviceCounters) +
                '}';
    }
}
