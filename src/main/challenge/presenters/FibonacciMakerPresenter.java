package main.challenge.presenters;

import main.challenge.interactors.responses.FibonacciMakerResponse;
import main.challenge.presenters.views.FibonacciMakerView;

import java.util.List;

public class FibonacciMakerPresenter implements FibonacciMakerResponse {
    private FibonacciMakerView view;

    public FibonacciMakerPresenter(FibonacciMakerView view) {
        this.view = view;
    }

    @Override
    public void displayFibonacci(List<String> strings) {
        view.displayFibonacci(strings);
    }

    @Override
    public void xInputIntegerError(String x) {
        String error = "ERROR: x input " + x + " is not an integer value";

        view.showXInputIntegerError(error);
    }

    @Override
    public void yInputIntegerError(String y) {
        String error = "ERROR: y input " + y + " is not an integer value";

        view.showYInputIntegerError(error);
    }

    @Override
    public void zInputIntegerError(String z) {
        String error = "ERROR: z input " + z + " is not an integer value";
        view.showZInputIntegerError(error);
    }

    @Override
    public void xNotPositiveIntegerError(String x) {
        String error = "ERROR: x input " + x + " is not a positive integer value";

        view.showXNotPositiveIntegerError(error);
    }

    @Override
    public void yNotPositiveIntegerError(String y) {
        String error = "ERROR: y input " + y + " is not a positive integer value";

        view.showYNotPositiveIntegerError(error);
    }

    @Override
    public void zNotPositiveIntegerError(String z) {
        String error = "ERROR: z input " + z + " is not a positive integer value";

        view.showZNotPositiveIntegerError(error);
    }

    @Override
    public void xInputMissingError(String x) {
        String error = "ERROR: x input is missing in FIBONACCI. Please enter integer value greater than zero";

        view.showXInputMissingError(error);
    }
}
