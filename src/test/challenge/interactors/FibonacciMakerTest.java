package challenge.interactors;

import main.challenge.ChallengeFactory;
import main.challenge.controllers.requests.FibonacciMakerRequest;
import main.challenge.gateways.GatewayFactory;
import main.challenge.gateways.GatewayRepository;
import main.challenge.interactors.FibonacciMaker;
import main.challenge.interactors.responses.FibonacciMakerResponse;
import org.junit.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.Mockito.*;

public class FibonacciMakerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private FibonacciMakerResponse response;
    @Mock
    private GatewayFactory factory;
    @Mock
    private GatewayRepository gatewayRepository;

    private FibonacciMakerRequest instance;
    private ArgumentCaptor<List<String>> argumentCaptor;

    @Before
    public void setup() {
        when(factory.createGatewayRepository()).thenReturn(gatewayRepository);
        ChallengeFactory.gatewayFactory = factory;
        instance = new FibonacciMaker(response);
        argumentCaptor = ArgumentCaptor.forClass(List.class);
    }

    @After
    public void destroy() {
        ChallengeFactory.gatewayFactory = null;
    }

    @Test
    public void standardFibonacci() {
        instance.setX("6");
        instance.setY("");
        instance.setZ("");

        instance.execute();

        verify(response, only()).displayFibonacci(argumentCaptor.capture());

        List<String> actual = argumentCaptor.getValue();

        Assert.assertEquals("0", actual.get(0));
        Assert.assertEquals("1", actual.get(1));
        Assert.assertEquals("1", actual.get(2));
        Assert.assertEquals("2", actual.get(3));
        Assert.assertEquals("3", actual.get(4));
        Assert.assertEquals("5", actual.get(5));
        Assert.assertEquals("8", actual.get(6));
    }

    @Test
    public void customFibonacci() {
        instance.setX("6");
        instance.setY("2");
        instance.setZ("3");

        instance.execute();

        verify(response, only()).displayFibonacci(argumentCaptor.capture());

        List<String> actual = argumentCaptor.getValue();

        Assert.assertEquals("2", actual.get(0));
        Assert.assertEquals("3", actual.get(1));
        Assert.assertEquals("5", actual.get(2));
        Assert.assertEquals("8", actual.get(3));
        Assert.assertEquals("13", actual.get(4));
        Assert.assertEquals("21", actual.get(5));
        Assert.assertEquals("34", actual.get(6));
    }

    @Test
    public void xNotInteger() {
        instance.setX("6.2");
        instance.setY("2");
        instance.setZ("3");

        instance.execute();

        verify(response, only()).xInputIntegerError("6.2");
    }

    @Test
    public void yNotInteger() {
        instance.setX("6");
        instance.setY("2.2");
        instance.setZ("3");

        instance.execute();

        verify(response, only()).yInputIntegerError("2.2");
    }

    @Test
    public void zNotInteger() {
        instance.setX("6");
        instance.setY("2");
        instance.setZ("3.2");

        instance.execute();

        verify(response, only()).zInputIntegerError("3.2");
    }

    @Test
    public void xNegativeInteger() {
        instance.setX("-7");
        instance.setY("2");
        instance.setZ("3");

        instance.execute();

        verify(response, only()).xNotPositiveIntegerError("-7");
    }

    @Test
    public void yNegativeInteger() {
        instance.setX("1");
        instance.setY("-2");
        instance.setZ("3");

        instance.execute();

        verify(response, only()).yNotPositiveIntegerError("-2");
    }

    @Test
    public void zNegativeInteger() {
        instance.setX("1");
        instance.setY("2");
        instance.setZ("-3");

        instance.execute();

        verify(response, only()).zNotPositiveIntegerError("-3");
    }
}
