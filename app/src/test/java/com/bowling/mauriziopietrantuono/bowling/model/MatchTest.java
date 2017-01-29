package com.bowling.mauriziopietrantuono.bowling.model;


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
    public void given_match_canPlayBall() throws InvalidPlayException {
        // GIVEN
        Match match = new Match();
        // THEN
        match.playBall(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_ballIsNegatve_Exception() throws InvalidPlayException {
        // GIVEN
        Match match = new Match();
        // THEN
        match.playBall(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_ballIsBiggerThanTen_Exception() throws InvalidPlayException {
        // GIVEN
        Match match = new Match();
        // THEN
        match.playBall(11);
    }

    @Test(expected = InvalidPlayException.class)
    public void when_playMoreThanTwentyMiss_then_Exception() throws InvalidPlayException {
        // GIVEN
        Match match = new Match();
        // THEN
        for (int i = 0; i <= 22; i++) {
            match.playBall(5);
        }
        fail();
    }

    @Test
    public void when_IplayOnce_then_IcanContinuePlaying() throws InvalidPlayException {
        // GIVEN
        Match match = new Match();
        // THEN
        assertTrue(match.playBall(10));
    }

    @Test
    public void when_playAllStrikes_then_IgetTwoBonuses() throws InvalidPlayException {
        // GIVEN
        Match match = new Match();
        // THEN
        for (int i = 0; i < 10; i++) {
            match.playBall(10);
        }
        assertTrue(match.playBall(5));
        assertTrue(match.playBall(5));
    }

    @Test(expected = InvalidPlayException.class)
    public void when_playAllStrikes_then_IgetTwoBonusesOnly() throws InvalidPlayException {
        // GIVEN
        Match match = new Match();
        // THEN
        for (int i = 0; i < 10; i++) {
            match.playBall(10);
        }
        assertTrue(match.playBall(5));
        assertTrue(match.playBall(5));
        assertTrue(match.playBall(5));
    }

}