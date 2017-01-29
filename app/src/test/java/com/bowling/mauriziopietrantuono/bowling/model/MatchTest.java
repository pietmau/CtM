package com.bowling.mauriziopietrantuono.bowling.model;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MatchTest {

    @Test
    public void given_match_canPlayBall() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(5);
    }

    @Test(expected = InvalidPlayException.class)
    public void when_ballIsNegatve_Exception() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(-1);
    }

    @Test(expected = InvalidPlayException.class)
    public void when_ballIsBiggerThanTen_Exception() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(11);
    }


    @Test
    public void when_IplayOnce_then_IcanContinuePlaying() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(10);
    }

    @Test(expected = InvalidPlayException.class)
    public void when_playMoreThanTwentyMiss_then_Exception() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        for (int i = 0; i <= 22; i++) {
            match.throwBall(5);
        }
        fail();
    }


    @Test
    public void when_playAllStrikes_then_IgetTwoBonuses() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        for (int i = 0; i < 10; i++) {
            match.throwBall(10);
        }
        // this should be OK
        match.throwBall(5);
        match.throwBall(5);
    }

    @Test(expected = InvalidPlayException.class)
    public void when_playAllStrikes_then_IgetTwoBonusesOnly() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        for (int i = 0; i < 10; i++) {
            match.throwBall(10);
        }
        // this should be OK
        match.throwBall(5);
        match.throwBall(5);

        // this should not be possible
        match.throwBall(5);
    }

    @Test
    public void when_playNineStrikesAndOneMiss_then_IgetOneBonuse() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        for (int i = 0; i < 9; i++) {
            match.throwBall(10);
        }
        //last frame
        match.throwBall(5);
        match.throwBall(5);

        // this should be OK
        match.throwBall(5);
    }

    @Test(expected = InvalidPlayException.class)
    public void when_playNineStrikesAndOneMiss_then_IgetOnBonusOnly() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        for (int i = 0; i < 9; i++) {
            match.throwBall(10);
        }
        //last frame
        match.throwBall(5);
        match.throwBall(5);

        // this should be OK
        match.throwBall(5);

        // this should not be possible
        match.throwBall(5);
    }

    @Test(expected = InvalidPlayException.class)
    public void when_lastNotStrikeOrSpare_then_fails() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        makeNineFrames(match);

        // last Frame
        match.throwBall(0);
        match.throwBall(0);

        // this should not be possible
        match.throwBall(0);
    }

    @Test
    public void when_lastStrike_then_IgetTwo() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        makeNineFrames(match);

        //last frame
        match.throwBall(10);

        // this should be OK
        match.throwBall(5);
        match.throwBall(5);
    }

    @Test(expected = InvalidPlayException.class)
    public void when_lastStrike_then_IgetTwoOnly() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        makeNineFrames(match);

        //last frame
        match.throwBall(10);

        // this should be OK
        match.throwBall(5);
        match.throwBall(5);

        // this should not be possible
        match.throwBall(5);
    }

    @Test
    public void when_lastSPare_then_IgetOneMore() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        makeNineFrames(match);

        //last frame
        match.throwBall(5);
        match.throwBall(5);

        // this should be OK
        match.throwBall(5);
    }

    @Test(expected = InvalidPlayException.class)
    public void when_lastSPare_then_IgetOneMoreOnly() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        makeNineFrames(match);

        //last frame
        match.throwBall(5);
        match.throwBall(5);

        // this should be OK
        match.throwBall(5);

        // this should not be possible
        match.throwBall(5);
    }

    private void makeNineFrames(BowlingMatch match) throws InvalidPlayException {
        match.throwBall(10);

        match.throwBall(5);
        match.throwBall(5);

        match.throwBall(10);

        match.throwBall(0);
        match.throwBall(0);

        match.throwBall(10);

        match.throwBall(5);
        match.throwBall(5);

        match.throwBall(0);
        match.throwBall(0);

        match.throwBall(10);

        match.throwBall(5);
        match.throwBall(5);
    }
}