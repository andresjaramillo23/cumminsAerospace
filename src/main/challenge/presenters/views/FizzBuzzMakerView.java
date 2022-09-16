package main.challenge.presenters.views;

import java.util.List;

public interface FizzBuzzMakerView {
    void showFizzDividendIntegerError(String error);

    void showBuzzDividendIntegerError(String error);

    void showInputValueIntegerError(String error);

    void showFizzNotPositiveIntegerError(String error);

    void showBuzzNotPositiveIntegerError(String error);

    void showInputNotPositiveIntegerError(String error);

    void displayFizzBuzz(List<String> fizzBuzz);
}
