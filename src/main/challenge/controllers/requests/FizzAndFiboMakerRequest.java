package main.challenge.controllers.requests;

public interface FizzAndFiboMakerRequest extends Request {
    void setFizzPhrase(String fizzPhrase);

    void setBuzzPhrase(String buzzPhrase);

    void setFizzDividend(String fizzDividend);

    void setBuzzDividend(String buzzDividend);
}
