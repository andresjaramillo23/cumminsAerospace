package main.challenge.interactors;

import com.google.common.base.Strings;
import main.challenge.controllers.requests.FizzBuzzMakerRequest;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FizzBuzzMaker implements FizzBuzzMakerRequest {
    private FizzBuzzMakerResponse response;
    private String fizzPhrase;
    private String buzzPhrase;
    private String fizzDividend;
    private String buzzDividend;
    private String input;

    public FizzBuzzMaker(FizzBuzzMakerResponse response) {
        this.response = Objects.requireNonNull(response);
    }

    @Override
    public void execute() {
        if (Strings.isNullOrEmpty(input))
            response.inputValueMissingError(input);
        else if (isNotInteger(fizzDividend))
            response.fizzDividendIntegerError(fizzDividend);
        else if (isNotInteger(buzzDividend))
            response.buzzDividendIntegerError(buzzDividend);
        else if (isNotInteger(input))
            response.inputValueIntegerError(input);
        else if (isNotPositiveInteger(fizzDividend))
            response.fizzNotPositiveIntegerError(fizzDividend);
        else if (isNotPositiveInteger(buzzDividend))
            response.buzzNotPositiveIntegerError(buzzDividend);
        else if (isNotPositiveInteger(input))
            response.inputNotPositiveIntegerError(input);
        else
            registerStrings();
    }

    private void registerStrings() {
        List<String> strings;
        strings = getFizzBuzzOutput();
        response.displayFizzBuzz(strings);
    }

    private List<String> getFizzBuzzOutput() {
        List<String> strings = new ArrayList<>();
        strings.add("0");
        for (int i = 1; i <= Integer.parseInt(input); i++) {
            if (isModule(i, fizzDividend) && isModule(i, buzzDividend))
                strings.add(fizzPhrase + buzzPhrase);
            else if (isModule(i, fizzDividend))
                strings.add(fizzPhrase);
            else if (isModule(i, buzzDividend))
                strings.add(buzzPhrase);
            else
                strings.add(String.valueOf(i));
        }

        return strings;
    }

    private boolean isNotInteger(String value) {
        boolean isInteger = false;
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            isInteger = true;
        }
        return isInteger;
    }

    private boolean isNotPositiveInteger(String i) {
        return Integer.parseInt(i) <= 0;
    }

    private boolean isModule(int value, String dividend) {
        return value % Integer.parseInt(dividend) == 0;
    }

    @Override
    public void setFizzPhrase(String fizzPhrase) {
        if (Strings.isNullOrEmpty(fizzPhrase))
            fizzPhrase = "fizz";

        this.fizzPhrase = fizzPhrase;
    }

    @Override
    public void setBuzzPhrase(String buzzPhrase) {
        if (Strings.isNullOrEmpty(buzzPhrase))
            buzzPhrase = "buzz";

        this.buzzPhrase = buzzPhrase;
    }

    @Override
    public void setFizzDividend(String fizzDividend) {
        if (Strings.isNullOrEmpty(fizzDividend))
            fizzDividend = "3";


        this.fizzDividend = fizzDividend;
    }

    @Override
    public void setBuzzDividend(String buzzDividend) {
        if (Strings.isNullOrEmpty(buzzDividend))
            buzzDividend = "5";

        this.buzzDividend = buzzDividend;
    }

    @Override
    public void setInput(String input) {
        this.input = input;
    }
}
