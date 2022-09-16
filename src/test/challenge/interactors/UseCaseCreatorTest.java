package challenge.interactors;

import main.challenge.controllers.requests.FibonacciMakerRequest;
import main.challenge.controllers.requests.FizzAndFiboMakerRequest;
import main.challenge.controllers.requests.FizzBuzzMakerRequest;
import main.challenge.controllers.requests.RequestFactory;
import main.challenge.interactors.FibonacciMaker;
import main.challenge.interactors.FizzAndFiboMaker;
import main.challenge.interactors.FizzBuzzMaker;
import main.challenge.interactors.UseCaseCreator;
import main.challenge.interactors.responses.FibonacciMakerResponse;
import main.challenge.interactors.responses.FizzAndFiboMakerResponse;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class UseCaseCreatorTest {
    private RequestFactory factory;

    @Before
    public void setup() {
        factory = new UseCaseCreator();
    }

    @After
    public void destroy() {
        factory = null;
    }

    @Test
    public void makeFizzBuzz() {
        FizzBuzzMakerResponse response = mock(FizzBuzzMakerResponse.class);
        FizzBuzzMakerRequest request = factory.makeFizzBuzz(response);

        Assert.assertSame(FizzBuzzMaker.class, request.getClass());
    }

    @Test
    public void makeFibonacci() {
        FibonacciMakerResponse response = mock(FibonacciMakerResponse.class);
        FibonacciMakerRequest request = factory.makeFibonacci(response);

        Assert.assertSame(FibonacciMaker.class, request.getClass());
    }

    @Test
    public void makeFizzAndFibo() {
        FizzAndFiboMakerResponse response = mock(FizzAndFiboMakerResponse.class);
        FizzAndFiboMakerRequest request = factory.makeFizzAndFibo(response);

        Assert.assertSame(FizzAndFiboMaker.class, request.getClass());
    }
}
