package main.challenge.controllers;

import main.challenge.ChallengeFactory;
import main.challenge.controllers.requests.FibonacciMakerRequest;
import main.challenge.controllers.requests.FizzAndFiboMakerRequest;
import main.challenge.controllers.requests.FizzBuzzMakerRequest;
import main.challenge.interactors.responses.FibonacciMakerResponse;
import main.challenge.interactors.responses.FizzAndFiboMakerResponse;
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

    public void makeFibonacci(Properties properties, FibonacciMakerResponse response) {
        FibonacciMakerRequest request = ChallengeFactory.requestFactory.makeFibonacci(response);
        request.setX(properties.getProperty("x"));
        request.setY(properties.getProperty("y"));
        request.setZ(properties.getProperty("z"));
        request.execute();
    }

    public void makeFizzAndFibo(Properties properties, FizzAndFiboMakerResponse response) {
        FizzAndFiboMakerRequest request = ChallengeFactory.requestFactory.makeFizzAndFibo(response);
        request.setFizzPhrase(properties.getProperty("fizzPhrase"));
        request.setBuzzPhrase(properties.getProperty("buzzPhrase"));
        request.setFizzDividend(properties.getProperty("3"));
        request.setBuzzDividend(properties.getProperty("5"));
        request.execute();
    }
}
