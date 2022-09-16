package main.challenge.gateways;

import java.util.ArrayList;
import java.util.List;

public class InMemoryGatewayRepository implements GatewayRepository {
    private static List<String> data = new ArrayList<>();

    @Override
    public void registerFibonacci(List<String> strings) {
        data = strings;
    }

    @Override
    public List<String> retrieveData() {
        return data;
    }
}
