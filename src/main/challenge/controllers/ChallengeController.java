package main.challenge.controllers;

import main.challenge.ChallengeFactory;
import main.challenge.controllers.requests.FizzBuzzMakerRequest;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;

import java.util.Properties;

public class ChallengeController {
    public void makeFizzBuzz(Properties properties, FizzBuzzMakerResponse response) {
        FizzBuzzMakerRequest request = ChallengeFactory.requestFactory.makeFizzBuzz(response);
        request.setFizzPhrase(properties.getProperty("fizzPhrase"));
        request.setBuzzPhrase(properties.getProperty("buzzPhrase"));
        request.setFizzDividend(properties.getProperty("fizzDividend"));
        request.setBuzzDividend(properties.getProperty("buzzDividend"));
        request.setInput(properties.getProperty("input"));
        request.execute();
    }
}
