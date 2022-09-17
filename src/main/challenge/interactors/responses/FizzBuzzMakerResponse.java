package main.challenge.interactors.responses;

import java.util.List;

public interface FizzBuzzMakerResponse {
    void displayFizzBuzz(List<String> output);

    void fizzDividendIntegerError(String fizzDividend);

    void buzzDividendIntegerError(String buzzDividend);

    void inputValueIntegerError(String s);

    void fizzNotPositiveIntegerError(String s);

    void buzzNotPositiveIntegerError(String s);

    void inputNotPositiveIntegerError(String s);

    void inputValueMissingError(String input);
}
