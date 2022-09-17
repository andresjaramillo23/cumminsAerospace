import main.challenge.ChallengeFactory;
import main.challenge.gateways.GatewayFactoryImplementation;
import main.challenge.interactors.UseCaseCreator;
import main.challenge.ui.ChallengeUI;

public class Main {
    public static void main(String[] args) {
        initializeServices();
        ChallengeUI challengeUI = new ChallengeUI();
    }

    private  static void initializeServices() {
        ChallengeFactory.gatewayFactory = new GatewayFactoryImplementation();
        ChallengeFactory.requestFactory = new UseCaseCreator();
    }
}
