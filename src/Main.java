import main.challenge.ChallengeFactory;
import main.challenge.gateways.GatewayFactoryImplementation;
import main.challenge.interactors.UseCaseCreator;

public class Main {
    public static void main(String[] args) {
        initializeServices();
        System.out.println("Welcome to the Grocery Express Delivery Service!");
    }

    private  static void initializeServices() {
        ChallengeFactory.gatewayFactory = new GatewayFactoryImplementation();
        ChallengeFactory.requestFactory = new UseCaseCreator();
    }
}
