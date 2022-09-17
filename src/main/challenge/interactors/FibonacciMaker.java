package main.challenge.interactors;

import com.google.common.base.Strings;
import main.challenge.ChallengeFactory;
import main.challenge.controllers.requests.FibonacciMakerRequest;
import main.challenge.gateways.GatewayRepository;
import main.challenge.interactors.responses.FibonacciMakerResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FibonacciMaker implements FibonacciMakerRequest {
    private FibonacciMakerResponse response;
    private String x;
    private String y;
    private String z;

    public FibonacciMaker(FibonacciMakerResponse response) {
        this.response = Objects.requireNonNull(response);
    }

    @Override
    public void execute() {
        GatewayRepository gatewayRepository = ChallengeFactory.gatewayFactory.createGatewayRepository();

        if (Strings.isNullOrEmpty(x))
            response.xInputMissingError(x);
        else if (isNotInteger(x))
            response.xInputIntegerError(x);
        else if (isNotInteger(y))
            response.yInputIntegerError(y);
        else if (isNotInteger(z))
            response.zInputIntegerError(z);
        else if (isNotPositiveInteger(x))
            response.xNotPositiveIntegerError(x);
        else if (isNotPositiveInteger(y))
            response.yNotPositiveIntegerError(y);
        else if (isNotPositiveInteger(z))
            response.zNotPositiveIntegerError(z);
        else
            registerStrings(gatewayRepository);
    }

    private void registerStrings(GatewayRepository gatewayRepository) {
        List<String> strings = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt(x); i++)
            strings.add(String.valueOf(getFibonacci(i)));

        response.displayFibonacci(strings);
        gatewayRepository.registerFibonacci(strings);
    }

    int getFibonacci(int n) {
        double phi = (Integer.parseInt(y) + Math.sqrt(Integer.parseInt(y) + 2 +Integer.parseInt(z))) / Integer.parseInt(z);
        return (int) Math.round(Math.pow(phi, n)
                / Math.sqrt(Integer.parseInt(y) + 2 +Integer.parseInt(z)));
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

    @Override
    public void setX(String x) {
        this.x = x;
    }

    @Override
    public void setY(String y) {
        if (Strings.isNullOrEmpty(y))
            y = "1";

        this.y = y;
    }

    @Override
    public void setZ(String z) {
        if (Strings.isNullOrEmpty(z))
            z = "2";

        this.z = z;
    }
}
