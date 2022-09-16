package main.challenge.gateways;

import java.util.List;

public interface GatewayRepository {
    void registerFibonacci(List<String> strings);

    List<String> retrieveData();
}
