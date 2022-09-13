package main.challenge.interactors;

import main.challenge.controllers.requests.FizzBuzzMakerRequest;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;

public class FizzBuzzMaker implements FizzBuzzMakerRequest {
    private FizzBuzzMakerResponse response;

    public FizzBuzzMaker(FizzBuzzMakerResponse response) {
        this.response = response;

    }

    @Override
    public void execute() {

    }
    @Override
    public void setFizzPhrase(String fizzPhrase) {

    }

    @Override
    public void setBuzzPhrase(String buzzPhrase) {

    }

    @Override
    public void setFizzDividend(String fizzDividend) {

    }

    @Override
    public void setBuzzDividend(String buzzDividend) {

    }

    @Override
    public void setInput(String input) {

    }
}
