package main.challenge.presenters.views;

import java.util.List;

public interface FizzAndFiboMakerView {
    void showFizzDividendIntegerError(String error);

    void showBuzzDividendIntegerError(String error);

    void showFizzNotPositiveIntegerError(String error);

    void showBuzzNotPositiveIntegerError(String error);

    void displayFizzAndFibo(List<String> fizzBuzz);
}
