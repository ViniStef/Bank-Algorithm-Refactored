package main.java.bankalgorithm.model;

public class Client {
    private int arrivedTime;
    private int exitTime;
    private ServiceType serviceType;

    public Client(int arrivedTime, ServiceType serviceType) {
        this.arrivedTime = arrivedTime;
        this.serviceType = serviceType;
        this.exitTime = arrivedTime + this.serviceType.serviceValue;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public int getArrivedTime() {
        return arrivedTime;
    }

    public int getExitTime() {
        return exitTime;
    }

    @Override
    public String toString() {
        return "Client{" +
                "arrivedTime=" + arrivedTime +
                ", exitTime=" + exitTime +
                ", serviceType=" + serviceType +
                '}';
    }
}
