package challenge.interactors;

import main.challenge.ChallengeFactory;
import main.challenge.controllers.requests.FizzBuzzMakerRequest;
import main.challenge.gateways.GatewayFactory;
import main.challenge.gateways.GatewayRepository;
import main.challenge.interactors.FizzBuzzMaker;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;
import org.junit.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.Mockito.*;

public class FizzBuzzMakerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private FizzBuzzMakerResponse response;
    @Mock
    private GatewayFactory factory;
    @Mock
    private GatewayRepository gatewayRepository;

    private FizzBuzzMakerRequest instance;
    private ArgumentCaptor<List<String>> argumentCaptor;

    @Before
    public void setup() {
        when(factory.createGatewayRepository()).thenReturn(gatewayRepository);
        ChallengeFactory.gatewayFactory = factory;
        instance = new FizzBuzzMaker(response);
        argumentCaptor = ArgumentCaptor.forClass(List.class);
    }

    @After
    public void destroy() {
        ChallengeFactory.gatewayFactory = null;
    }

    @Test
    public void standardFizzBuzz() {
        instance.setFizzPhrase("");
        instance.setBuzzPhrase("");
        instance.setFizzDividend("");
        instance.setBuzzDividend("");
        instance.setInput("3");

        instance.execute();

        verify(response, only()).displayFizzBuzz(argumentCaptor.capture());

        List<String> actual = argumentCaptor.getValue();

        Assert.assertEquals("0", actual.get(0));
        Assert.assertEquals("1", actual.get(1));
        Assert.assertEquals("2", actual.get(2));
        Assert.assertEquals("fizz", actual.get(3));
    }

    @Test
    public void customFizzBuzz() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("7");
        instance.setBuzzDividend("9");
        instance.setInput("63");

        instance.execute();

        verify(response, only()).displayFizzBuzz(argumentCaptor.capture());

        List<String> actual = argumentCaptor.getValue();

        Assert.assertEquals("0", actual.get(0));
        Assert.assertEquals("lolo", actual.get(7));
        Assert.assertEquals("popo", actual.get(9));
        Assert.assertEquals("lolopopo", actual.get(63));
    }

    @Test
    public void fizzDividendNoInteger() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("7.3");
        instance.setBuzzDividend("9");
        instance.setInput("63");

        instance.execute();

        verify(response, only()).fizzDividendIntegerError("7.3");
    }

    @Test
    public void buzzDividendNoInteger() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("7");
        instance.setBuzzDividend("9.2");
        instance.setInput("63");

        instance.execute();

        verify(response, only()).buzzDividendIntegerError("9.2");
    }

    @Test
    public void inputNoInteger() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("7");
        instance.setBuzzDividend("9");
        instance.setInput("6.3");

        instance.execute();

        verify(response, only()).inputValueIntegerError("6.3");
    }

    @Test
    public void fizzNegativeInteger() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("-5");
        instance.setBuzzDividend("9");
        instance.setInput("6");

        instance.execute();

        verify(response, only()).fizzNotPositiveIntegerError("-5");
    }

    @Test
    public void buzzNegativeInteger() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("9");
        instance.setBuzzDividend("-3");
        instance.setInput("6");

        instance.execute();

        verify(response, only()).buzzNotPositiveIntegerError("-3");
    }

    @Test
    public void inputNegativeInteger() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("6");
        instance.setBuzzDividend("9");
        instance.setInput("-6");

        instance.execute();

        verify(response, only()).inputNotPositiveIntegerError("-6");
    }
}
