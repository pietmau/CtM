package com.bowling.mauriziopietrantuono.bowling.model;

import com.bowling.mauriziopietrantuono.bowling.model.frame.StrikeFrame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MatchTest {

    @Test
    public void given_foo_when_bar_then_fobar() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    public void given_match_canPlayBall() {
        // GIVEN
        Match match = new Match();
        // THEN
        match.playBall(5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void when_ballIsNegatve_Exception() {
        // GIVEN
        Match match = new Match();
        // THEN
        match.playBall(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void when_ballIsBiggerThanTen_Exception() {
        // GIVEN
        Match match = new Match();
        // THEN
        match.playBall(11);
    }

    @Test
    public void when_scoreInTenStrikeIsAdded() {
        // GIVEN
        Match match = new Match();
        // THEN
        match.playBall(10);
        assertTrue((match.head instanceof StrikeFrame));
    }
}