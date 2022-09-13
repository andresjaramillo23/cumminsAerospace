package main.challenge.controllers.requests;

import main.challenge.interactors.responses.FizzBuzzMakerResponse;

public interface RequestFactory {
    FizzBuzzMakerRequest makeFizzBuzz(FizzBuzzMakerResponse response);
}
