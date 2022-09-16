package main.challenge.presenters;

import main.challenge.interactors.responses.FizzBuzzMakerResponse;
import main.challenge.presenters.views.FizzBuzzMakerView;

import java.util.List;

public class FizzBuzzMakerPresenter implements FizzBuzzMakerResponse {
    private FizzBuzzMakerView view;

    public FizzBuzzMakerPresenter(FizzBuzzMakerView view) {
        this.view = view;
    }

    @Override
    public void displayFizzBuzz(List<String> output) {
        view.displayFizzBuzz(output);
    }

    @Override
    public void fizzDividendIntegerError(String fizzDividend) {
        String error = "ERROR: fizz input " + fizzDividend + " is not an integer value";

        view.showFizzDividendIntegerError(error);
    }

    @Override
    public void buzzDividendIntegerError(String buzzDividend) {
        String error = "ERROR: buzz input " + buzzDividend + " is not an integer value";

        view.showBuzzDividendIntegerError(error);
    }

    @Override
    public void inputValueIntegerError(String input) {
        String error = "ERROR: input " + input + " is not an integer value";

        view.showInputValueIntegerError(error);
    }

    @Override
    public void fizzNotPositiveIntegerError(String fizz) {
        String error = "ERROR: fizz input " + fizz + " is not a positive integer value";

        view.showFizzNotPositiveIntegerError(error);
    }

    @Override
    public void buzzNotPositiveIntegerError(String buzz) {
        String error = "ERROR: buzz input " + buzz + " is not a positive integer value";

        view.showBuzzNotPositiveIntegerError(error);
    }

    @Override
    public void inputNotPositiveIntegerError(String input) {
        String error = "ERROR: input " + input + " is not a positive integer value";

        view.showInputNotPositiveIntegerError(error);
    }
}
