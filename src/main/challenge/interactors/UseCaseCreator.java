package main.challenge.interactors;

import main.challenge.controllers.requests.FizzBuzzMakerRequest;
import main.challenge.controllers.requests.RequestFactory;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;

public class UseCaseCreator implements RequestFactory {
    @Override
    public FizzBuzzMakerRequest makeFizzBuzz(FizzBuzzMakerResponse response) {
        return new FizzBuzzMaker(response);
    }
}
