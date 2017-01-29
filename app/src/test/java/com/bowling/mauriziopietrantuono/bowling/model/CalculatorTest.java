package com.bowling.mauriziopietrantuono.bowling.model;

import com.bowling.mauriziopietrantuono.bowling.model.frame.StrikeFrame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Test
    public void given_foo_when_bar_then_fobar() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    public void when_allStrikes_then_containsElevenFrames() {
        // GIVEN
        Match match = new Match();

        // WHEN
        // THEN
    }

    @Test
    public void when_add_elvenFrames_exceptionIsTrown() {
        // WHEN
        Match match = new Match();
        for (int i = 0; i <= 11; i++) {
            match.addFrame(new StrikeFrame());
        }
        fail();
    }


}