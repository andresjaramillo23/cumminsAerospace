package main.challenge.presenters.views;

import java.util.List;

public interface FibonacciMakerView {
    void showXInputIntegerError(String error);

    void showYInputIntegerError(String error);

    void showZInputIntegerError(String error);

    void showXNotPositiveIntegerError(String error);

    void showYNotPositiveIntegerError(String error);

    void showZNotPositiveIntegerError(String error);

    void displayFibonacci(List<String> fibonacci);
}
