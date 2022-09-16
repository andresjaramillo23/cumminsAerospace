package main.challenge.interactors.responses;

import java.util.List;

public interface FibonacciMakerResponse {
    void displayFibonacci(List<String> strings);

    void xInputIntegerError(String s);

    void yInputIntegerError(String s);

    void zInputIntegerError(String s);

    void xNotPositiveIntegerError(String s);

    void yNotPositiveIntegerError(String s);

    void zNotPositiveIntegerError(String s);
}
