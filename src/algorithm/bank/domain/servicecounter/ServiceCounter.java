package algorithm.bank.domain.servicecounter;

public class ServiceCounter {
    private int serviceAvailableAt = 0;
    private Availability availability = Availability.AVAILABLE;

    public ServiceCounter() {
    }

    public enum Availability {
        BUSY,
        AVAILABLE
    }

    public int getServiceAvailableAt() {
        return serviceAvailableAt;
    }

    public void setServiceAvailableAt(int serviceAvailableAt) {
        this.serviceAvailableAt = serviceAvailableAt;
        this.availability = Availability.BUSY;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "ServiceCounter{" +
                "serviceAvailableAt=" + serviceAvailableAt +
                ", availability=" + availability +
                '}';
    }
}
