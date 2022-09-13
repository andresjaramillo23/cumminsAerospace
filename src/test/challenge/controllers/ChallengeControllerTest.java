package challenge.controllers;

import main.challenge.ChallengeFactory;
import main.challenge.controllers.ChallengeController;
import main.challenge.controllers.requests.FizzBuzzMakerRequest;
import main.challenge.controllers.requests.RequestFactory;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;
import org.junit.After;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Properties;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChallengeControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private RequestFactory factory;

    private ChallengeController controller;

    @Before
    public void setup() {
        controller = new ChallengeController();
    }

    @After
    public void destroy() {
        ChallengeFactory.requestFactory = null;
    }

    @Test
    public void makeFizzBuzz() {
        FizzBuzzMakerRequest request = mock(FizzBuzzMakerRequest.class);
        FizzBuzzMakerResponse response = mock(FizzBuzzMakerResponse.class);
        when(factory.makeFizzBuzz(response)).thenReturn(request);
        ChallengeFactory.requestFactory = factory;

        Properties properties = new Properties();
        properties.setProperty("fizzPhrase", "fizz");
        properties.setProperty("buzzPhrase", "buzz");
        properties.setProperty("fizzDividend", "3");
        properties.setProperty("buzzDividend", "5");
        properties.setProperty("input", "20");

        controller.makeFizzBuzz(properties, response);
        InOrder inOrder = Mockito.inOrder(request);
        inOrder.verify(request).setFizzPhrase(properties.getProperty("fizzPhrase"));
        inOrder.verify(request).setBuzzPhrase(properties.getProperty("buzzPhrase"));
        inOrder.verify(request).setFizzDividend(properties.getProperty("fizzDividend"));
        inOrder.verify(request).setBuzzDividend(properties.getProperty("buzzDividend"));
        inOrder.verify(request).setInput(properties.getProperty("input"));
        inOrder.verify(request).execute();
    }
}
