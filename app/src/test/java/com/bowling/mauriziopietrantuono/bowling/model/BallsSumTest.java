package com.bowling.mauriziopietrantuono.bowling.model;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BallsSumTest {


    @Test(expected = InvalidPlayException.class)
    public void when_ballSummBiggerThanTen() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(8);
        match.throwBall(8);
    }

    @Test
    public void when_oneBall() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(8);
    }

    @Test
    public void when_twoBallsBall() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(5);
        match.throwBall(5);
    }

    @Test
    public void when_threeBallsBall() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(5);
        match.throwBall(5);
        match.throwBall(5);

    }

    @Test(expected = InvalidPlayException.class)
    public void when_threeBallsBallandAStrike() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(5);
        match.throwBall(5);
        match.throwBall(5);
        match.throwBall(10);
    }

    @Test(expected = InvalidPlayException.class)
    public void when_nineStrikesB() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        for (int i = 0; i < 9; i++) {
            match.throwBall(10);
        }
        match.throwBall(9);
        match.throwBall(9);
    }
}