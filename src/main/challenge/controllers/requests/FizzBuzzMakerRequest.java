package main.challenge.controllers.requests;

public interface FizzBuzzMakerRequest extends Request {
    void setFizzPhrase(String fizzPhrase);

    void setBuzzPhrase(String buzzPhrase);

    void setFizzDividend(String fizzDividend);

    void setBuzzDividend(String buzzDividend);

    void setInput(String input);
}
