package algorithm.bank.domain.servicecounter;

public interface ServiceCounterVerification {

    public int getEarliestCounterAvailableTime();

    public void addClientToCounter(int currentTime, int actionTime);
}