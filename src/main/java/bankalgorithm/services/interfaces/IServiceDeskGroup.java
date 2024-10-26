package main.java.bankalgorithm.services.interfaces;

import main.java.bankalgorithm.models.Client;

public interface IServiceDeskGroup {
    int getEarliestDeskAvailableTime();

    void resetServiceAtTime(int currentTime);

    boolean addClientToDesk(int currentTime, Client client);
}
