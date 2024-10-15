package main.java.bankalgorithm.model;

public class Client {
    private int arrivedTime;
    private int exitTime;

    public Client(int arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    public int getArrivedTime() {
        return arrivedTime;
    }

    public int getExitTime() {
        return exitTime;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }
}
