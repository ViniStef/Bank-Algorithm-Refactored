package algorithm.bank.domain.servicecounter;

import java.util.Arrays;

public class ServiceCounterGroup implements ServiceCounterVerification {
    private ServiceCounter[] serviceCounters;

    public ServiceCounterGroup(ServiceCounter[] serviceCounters) {
        this.serviceCounters = serviceCounters;
    }

    public ServiceCounter[] getServiceCounters() {
        return this.serviceCounters;
    }

    @Override
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

    @Override
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
