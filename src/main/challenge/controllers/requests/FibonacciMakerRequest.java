package main.challenge.controllers.requests;

public interface FibonacciMakerRequest extends Request {
    void setX(String x);

    void setY(String y);

    void setZ(String z);
}
