package main.challenge.interactors;

import main.challenge.controllers.requests.FizzBuzzMakerRequest;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;

public class FizzBuzzMaker implements FizzBuzzMakerRequest {
    private FizzBuzzMakerResponse response;

    public FizzBuzzMaker(FizzBuzzMakerResponse response) {
        this.response = response;
    }
}
