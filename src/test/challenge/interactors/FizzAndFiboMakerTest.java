package challenge.interactors;

import main.challenge.ChallengeFactory;
import main.challenge.controllers.requests.FizzAndFiboMakerRequest;
import main.challenge.gateways.GatewayFactory;
import main.challenge.gateways.GatewayRepository;
import main.challenge.interactors.FizzAndFiboMaker;
import main.challenge.interactors.responses.FizzAndFiboMakerResponse;
import org.junit.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.Mockito.*;

public class FizzAndFiboMakerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private FizzAndFiboMakerResponse response;
    @Mock
    private GatewayFactory factory;
    @Mock
    private GatewayRepository gatewayRepository;

    private FizzAndFiboMakerRequest instance;
    private ArgumentCaptor<List<String>> argumentCaptor;

    @Before
    public void setup() {
        when(factory.createGatewayRepository()).thenReturn(gatewayRepository);
        ChallengeFactory.gatewayFactory = factory;
        instance = new FizzAndFiboMaker(response);
        argumentCaptor = ArgumentCaptor.forClass(List.class);
    }

    @After
    public void destroy() {
        ChallengeFactory.gatewayFactory = null;
    }

    @Test
    public void standard() {
        List<String> fibonacci =  List.of("1", "1", "2", "3", "5", "8");
        when(gatewayRepository.retrieveData()).thenReturn(fibonacci);
        instance.setFizzPhrase("");
        instance.setBuzzPhrase("");
        instance.setFizzDividend("");
        instance.setBuzzDividend("");

        instance.execute();

        verify(response, only()).displayFizzAndFibo(argumentCaptor.capture());

        List<String> actual = argumentCaptor.getValue();

        Assert.assertEquals("1", actual.get(0));
        Assert.assertEquals("1", actual.get(1));
        Assert.assertEquals("2", actual.get(2));
        Assert.assertEquals("fizz", actual.get(3));
        Assert.assertEquals("buzz", actual.get(4));
        Assert.assertEquals("8", actual.get(5));
    }

    @Test
    public void standard2() {
        List<String> fibonacci =  List.of("1", "1", "2", "3", "5", "8", "13", "21", "34", "55", "89", "144");

        when(gatewayRepository.retrieveData()).thenReturn(fibonacci);
        instance.setFizzPhrase("LALO");
        instance.setBuzzPhrase("TUTU");
        instance.setFizzDividend("2");
        instance.setBuzzDividend("4");
        instance.execute();

        verify(response, only()).displayFizzAndFibo(argumentCaptor.capture());

        List<String> actual = argumentCaptor.getValue();

        Assert.assertEquals("1", actual.get(0));
        Assert.assertEquals("1", actual.get(1));
        Assert.assertEquals("LALO", actual.get(2));
        Assert.assertEquals("3", actual.get(3));
        Assert.assertEquals("5", actual.get(4));
        Assert.assertEquals("LALOTUTU", actual.get(5));
        Assert.assertEquals("13", actual.get(6));
        Assert.assertEquals("21", actual.get(7));
        Assert.assertEquals("LALO", actual.get(8));
        Assert.assertEquals("55", actual.get(9));
        Assert.assertEquals("89", actual.get(10));
        Assert.assertEquals("LALOTUTU", actual.get(11));
    }

    @Test
    public void fizzDividendNoInteger() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("7.3");
        instance.setBuzzDividend("9");

        instance.execute();

        verify(response, only()).fizzDividendIntegerError("7.3");
    }

    @Test
    public void buzzDividendNoInteger() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("7");
        instance.setBuzzDividend("9.2");

        instance.execute();

        verify(response, only()).buzzDividendIntegerError("9.2");
    }

    @Test
    public void fizzNegativeInteger() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("-5");
        instance.setBuzzDividend("9");

        instance.execute();

        verify(response, only()).fizzNotPositiveIntegerError("-5");
    }

    @Test
    public void buzzNegativeInteger() {
        instance.setFizzPhrase("lolo");
        instance.setBuzzPhrase("popo");
        instance.setFizzDividend("9");
        instance.setBuzzDividend("-3");

        instance.execute();

        verify(response, only()).buzzNotPositiveIntegerError("-3");
    }
}
