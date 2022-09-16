package main.challenge.presenters;

import main.challenge.interactors.responses.FizzAndFiboMakerResponse;
import main.challenge.presenters.views.FizzAndFiboMakerView;

import java.util.List;

public class FizzAndFiboMakerPresenter implements FizzAndFiboMakerResponse {
    private FizzAndFiboMakerView view;

    public FizzAndFiboMakerPresenter(FizzAndFiboMakerView view) {
        this.view = view;
    }

    @Override
    public void displayFizzAndFibo(List<String> strings) {
        view.displayFizzAndFibo(strings);
    }

    @Override
    public void fizzDividendIntegerError(String fizz) {
        String error = "ERROR: fizz input " + fizz + " is not an integer value";

        view.showFizzDividendIntegerError(error);
    }

    @Override
    public void buzzDividendIntegerError(String buzz) {
        String error = "ERROR: buzz input " + buzz + " is not an integer value";

        view.showBuzzDividendIntegerError(error);
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
}
