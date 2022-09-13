package challenge.controllers;

import main.challenge.controllers.requests.RequestFactory;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ChallengeControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private RequestFactory factory;
}
