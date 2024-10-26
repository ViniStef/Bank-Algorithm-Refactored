package main.java.bankalgorithm.services.interfaces;

import main.java.bankalgorithm.models.Client;

public interface IGenerateClient {
    Client tryGeneratingClient(int currentTime);
}
