package challenge.presenters;

import main.challenge.interactors.responses.FibonacciMakerResponse;
import main.challenge.interactors.responses.FizzBuzzMakerResponse;
import main.challenge.presenters.FibonacciMakerPresenter;
import main.challenge.presenters.FizzBuzzMakerPresenter;
import main.challenge.presenters.views.FibonacciMakerView;
import main.challenge.presenters.views.FizzBuzzMakerView;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

public class FibonacciMakerPresenterTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private FibonacciMakerView view;

    private FibonacciMakerResponse instance;

    @Before
    public void setup() {
        instance = new FibonacciMakerPresenter(view);
    }

    @After
    public void destroy() {
        instance = null;
    }

    @Test
    public void xInputIntegerError() {
        String error = "ERROR: x input 7.2 is not an integer value";

        instance.xInputIntegerError("7.2");

        verify(view, only()).showXInputIntegerError(error);
    }

    @Test
    public void yInputIntegerError() {
        String error = "ERROR: y input 7.2 is not an integer value";

        instance.yInputIntegerError("7.2");

        verify(view, only()).showYInputIntegerError(error);
    }

    @Test
    public void zInputIntegerError() {
        String error = "ERROR: z input 7.2 is not an integer value";

        instance.zInputIntegerError("7.2");

        verify(view, only()).showZInputIntegerError(error);
    }

    @Test
    public void xNotPositiveIntegerError() {
        String error = "ERROR: x input -7 is not a positive integer value";

        instance.xNotPositiveIntegerError("-7");

        verify(view, only()).showXNotPositiveIntegerError(error);
    }

    @Test
    public void yNotPositiveIntegerError() {
        String error = "ERROR: y input -7 is not a positive integer value";

        instance.yNotPositiveIntegerError("-7");

        verify(view, only()).showYNotPositiveIntegerError(error);
    }

    @Test
    public void zNotPositiveIntegerError() {
        String error = "ERROR: z input -7 is not a positive integer value";

        instance.zNotPositiveIntegerError("-7");

        verify(view, only()).showZNotPositiveIntegerError(error);
    }

    @Test
    public void displayFibonacci() {
        List<String> fibonacci =  List.of("1", "1", "2", "3", "5", "8");

        instance.displayFibonacci(fibonacci);

        verify(view, only()).displayFibonacci(fibonacci);
    }
}
