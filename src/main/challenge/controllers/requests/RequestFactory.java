package main.challenge.controllers.requests;

import main.challenge.interactors.responses.FibonacciMakerResponse;
import main.challenge.interactors.responses.FizzAndFiboMakerResponse;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;

public interface RequestFactory {
    FizzBuzzMakerRequest makeFizzBuzz(FizzBuzzMakerResponse response);

    FibonacciMakerRequest makeFibonacci(FibonacciMakerResponse response);

    FizzAndFiboMakerRequest makeFizzAndFibo(FizzAndFiboMakerResponse response);
}
