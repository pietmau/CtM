package com.bowling.mauriziopietrantuono.bowling.presenter;

import com.bowling.mauriziopietrantuono.bowling.model.BowlingMatch;
import com.bowling.mauriziopietrantuono.bowling.model.InvalidPlayException;
import com.bowling.mauriziopietrantuono.bowling.model.Scorer;
import com.bowling.mauriziopietrantuono.bowling.view.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {
    private static final String GARBAGE = "garbage";
    private static final String MESSAGE = "message";
    private Presenter presenter;
    @Mock MainView view;
    @Mock BowlingMatch bowlingMatch;
    @Mock Scorer scorer;

    @Before
    public void setUp() throws Exception {
        presenter = new Presenter(bowlingMatch, scorer);
        presenter.bind(view);
    }

    @Test
    public void when_wrongInput_then_userAlerted() {
        // GIVEN
        when(view.getPlay()).thenReturn(GARBAGE);
        // WHEN
        presenter.onGoClicked();
        // THEN
        verify(view).setTextEditError(null);
        verify(view).setTextEditError(anyString());
    }

    @Test
    public void when_invalidPlay_then_userAlerted() throws InvalidPlayException {
        doThrow(new InvalidPlayException(MESSAGE)).when(bowlingMatch).playBall(anyInt());

        when(view.getPlay()).thenReturn("2");
        // WHEN

        presenter.onGoClicked();
        // THEN
        verify(view).setError(MESSAGE);
    }

    @Test
    public void when_nvalidPlay_then_scoreIsUpdated() throws InvalidPlayException {
        //when(bowlingMatch.playBall(anyInt())).thenReturn(true);
        when(scorer.score(any(BowlingMatch.class))).thenReturn(100);
        when(view.getPlay()).thenReturn("2");
        // WHEN

        presenter.onGoClicked();
        // THEN
        verify(view).setScore(100);
    }
}