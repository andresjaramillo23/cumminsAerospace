package main.challenge.interactors;

import main.challenge.controllers.requests.FibonacciMakerRequest;
import main.challenge.controllers.requests.FizzAndFiboMakerRequest;
import main.challenge.controllers.requests.FizzBuzzMakerRequest;
import main.challenge.controllers.requests.RequestFactory;
import main.challenge.interactors.responses.FibonacciMakerResponse;
import main.challenge.interactors.responses.FizzAndFiboMakerResponse;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;

public class UseCaseCreator implements RequestFactory {
    @Override
    public FizzBuzzMakerRequest makeFizzBuzz(FizzBuzzMakerResponse response) {
        return new FizzBuzzMaker(response);
    }

    @Override
    public FibonacciMakerRequest makeFibonacci(FibonacciMakerResponse response) {
        return new FibonacciMaker(response);
    }

    @Override
    public FizzAndFiboMakerRequest makeFizzAndFibo(FizzAndFiboMakerResponse response) {
        return new FizzAndFiboMaker(response);
    }
}
