package main.challenge.interactors.responses;

import java.util.List;

public interface FizzAndFiboMakerResponse {
    void displayFizzAndFibo(List<String> strings);

    void fizzDividendIntegerError(String s);

    void buzzDividendIntegerError(String s);

    void fizzNotPositiveIntegerError(String s);

    void buzzNotPositiveIntegerError(String s);
}
