package main.challenge.interactors;

import com.google.common.base.Strings;
import main.challenge.ChallengeFactory;
import main.challenge.controllers.requests.FizzAndFiboMakerRequest;
import main.challenge.gateways.GatewayRepository;
import main.challenge.interactors.responses.FizzAndFiboMakerResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FizzAndFiboMaker implements FizzAndFiboMakerRequest {
    private FizzAndFiboMakerResponse response;
    private String fizzPhrase;
    private String buzzPhrase;
    private String fizzDividend;
    private String buzzDividend;
    private String input;

    public FizzAndFiboMaker(FizzAndFiboMakerResponse response) {
        this.response = Objects.requireNonNull(response);
    }

    @Override
    public void execute() {
        GatewayRepository gatewayRepository = ChallengeFactory.gatewayFactory.createGatewayRepository();
        List<String> dataFibonacci = gatewayRepository.retrieveData();

        if (isNotInteger(fizzDividend))
            response.fizzDividendIntegerError(fizzDividend);
        else if (isNotInteger(buzzDividend))
            response.buzzDividendIntegerError(buzzDividend);
        else if (isNotPositiveInteger(fizzDividend))
            response.fizzNotPositiveIntegerError(fizzDividend);
        else if (isNotPositiveInteger(buzzDividend))
            response.buzzNotPositiveIntegerError(buzzDividend);
        else
            response.displayFizzAndFibo(getFizzBuzzOutput(dataFibonacci));
    }

    private List<String> getFizzBuzzOutput(List<String> dataFibonacci) {
        List<String> strings = new ArrayList<>();
        for (String input : dataFibonacci) {
            if (isModule(Integer.parseInt(input), fizzDividend) && isModule(Integer.parseInt(input), buzzDividend))
                strings.add(fizzPhrase + buzzPhrase);
            else if (isModule(Integer.parseInt(input), fizzDividend))
                strings.add(fizzPhrase);
            else if (isModule(Integer.parseInt(input), buzzDividend))
                strings.add(buzzPhrase);
            else
                strings.add(input);
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
}
