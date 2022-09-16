package challenge.presenters;

import main.challenge.interactors.responses.FizzAndFiboMakerResponse;
import main.challenge.presenters.FizzAndFiboMakerPresenter;
import main.challenge.presenters.views.FizzAndFiboMakerView;
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

public class FizzAndFiboMakerPresenterTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private FizzAndFiboMakerView view;

    private FizzAndFiboMakerResponse instance;

    @Before
    public void setup() {
        instance = new FizzAndFiboMakerPresenter(view);
    }

    @After
    public void destroy() {
        instance = null;
    }

    @Test
    public void fizzDividendIntegerError() {
        String error = "ERROR: fizz input 7.2 is not an integer value";

        instance.fizzDividendIntegerError("7.2");

        verify(view, only()).showFizzDividendIntegerError(error);
    }

    @Test
    public void buzzDividendIntegerError() {
        String error = "ERROR: buzz input 7.2 is not an integer value";

        instance.buzzDividendIntegerError("7.2");

        verify(view, only()).showBuzzDividendIntegerError(error);
    }

    @Test
    public void fizzNotPositiveIntegerError() {
        String error = "ERROR: fizz input -5 is not a positive integer value";

        instance.fizzNotPositiveIntegerError("-5");

        verify(view, only()).showFizzNotPositiveIntegerError(error);
    }

    @Test
    public void buzzNotPositiveIntegerError() {
        String error = "ERROR: buzz input -3 is not a positive integer value";

        instance.buzzNotPositiveIntegerError("-3");

        verify(view, only()).showBuzzNotPositiveIntegerError(error);
    }

    @Test
    public void displayFizzAndFibo() {
        List<String> fizzBuzz =  List.of("1", "2", "fizz", "4", "buzz", "fizz");

        instance.displayFizzAndFibo(fizzBuzz);

        verify(view, only()).displayFizzAndFibo(fizzBuzz);
    }
}
