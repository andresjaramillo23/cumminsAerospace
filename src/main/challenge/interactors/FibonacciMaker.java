package main.challenge.interactors;

import com.google.common.base.Strings;
import main.challenge.ChallengeFactory;
import main.challenge.controllers.requests.FibonacciMakerRequest;
import main.challenge.gateways.GatewayRepository;
import main.challenge.interactors.responses.FibonacciMakerResponse;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        //Call the gateway so the output can be registered
        GatewayRepository gatewayRepository = ChallengeFactory.gatewayFactory.createGatewayRepository();

        //Logic for evaluating the input from the user and having the corresponding response
        if (isNotInteger(x))
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
            //if all the input is fine from the user then response to the output
            registerStrings(gatewayRepository);
    }

    private void registerStrings(GatewayRepository gatewayRepository) {
        // calculate limit input from user as to how long is the series
        int seriesLength = Integer.parseInt(x) + 1;

        // collect string of the Fibonacci sequence
        List<String> strings = IntStream.range(0, seriesLength)
                .map(this::getFibonacci)
                .boxed()
                .map(Objects::toString)
                .collect(Collectors.toList());

        //Pass values into the response
        response.displayFibonacci(strings);

        //save values to the gateway so they could be used for FizzBuzzNacci series
        gatewayRepository.registerFibonacci(strings);
    }

    int getFibonacci(int n) {
        // Initialize the first 2 values of the series based on the user's input
        int initialValueY = Integer.parseInt(y);
        int initialValueZ = Integer.parseInt(z);

        //Perform recursion since the sequence is the sum of the previous 2 numbers
        if (n == 0)
            return initialValueY;
        else if (n == 1)
            return initialValueZ;
        else
            return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    private boolean isNotInteger(String value) {
        //Evaluate if the input is not an integer
        boolean isInteger = false;
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            isInteger = true;
        }
        return isInteger;
    }

    private boolean isNotPositiveInteger(String i) {
        return Integer.parseInt(i) < 0;
    }

    @Override
    public void setX(String x) {
        if (Strings.isNullOrEmpty(x))
            // set the default output as 5 for the length of the series
            x = "4";

        this.x = x;
    }

    @Override
    public void setY(String y) {
        if (Strings.isNullOrEmpty(y))
            //set default value if user doesn't enter any number
            y = "0";

        this.y = y;
    }

    @Override
    public void setZ(String z) {
        if (Strings.isNullOrEmpty(z))
            //set default value if user doesn't enter any number
            z = "1";

        this.z = z;
    }
}
