package com.bowling.mauriziopietrantuono.bowling.model;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.bowling.mauriziopietrantuono.bowling.model.Helper.makeSomeNineFrames;
import static com.bowling.mauriziopietrantuono.bowling.model.Helper.makeSomeOtherNineFrames;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ScorerText {

    @Test
    public void when_playFive_scoreIsFive() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(5);
        Scorer scorer = new Scorer();
        assertEquals(5, scorer.score(match));
    }

    @Test
    public void when_strike_scoreIsTen() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.throwBall(10);
        Scorer scorer = new Scorer();
        assertEquals(10, scorer.score(match));
    }

    @Test
    public void when_strikeAndOtherTwoPlayes_scoreIsCorrect() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();


        match.throwBall(10);
        int firstFrameScore = 10 + 5 + 5;
        match.throwBall(5);
        match.throwBall(5);
        int secondFrameScore = 10;
        Scorer scorer = new Scorer();
        assertEquals(firstFrameScore + secondFrameScore, scorer.score(match));
    }

    @Test
    public void when_TwostrikeAndOtherTwoPlayes_scoreIsCorrect() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();

        //first frame
        match.throwBall(10);
        int firstFrameScore = 10 + 10 + 5;
        // second frame
        match.throwBall(10);
        int seconfFrameScore = 10 + 5 + 5;
        // third frame
        match.throwBall(5);
        match.throwBall(5);
        int thirdFrameScore = 10;
        Scorer scorer = new Scorer();
        assertEquals(firstFrameScore + seconfFrameScore + thirdFrameScore, scorer.score(match));
    }

    @Test
    public void someMatchIsScoredCorrectly() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeNineFrames(match);
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }

    @Test
    public void someOtherMatchIsScoredCorrectly() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeOtherNineFrames(match);
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }

    @Test
    public void lastIsStrikeOtherFrames() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeOtherNineFrames(match);
        match.throwBall(10);
        match.throwBall(10);
        match.throwBall(10);
        score = score + 10 + 10 + 10;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }

    @Test
    public void lastIsASpareOtherFrames() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeOtherNineFrames(match);
        match.throwBall(5);
        match.throwBall(5);
        match.throwBall(8);
        score = score + 10 + 8;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }

    @Test
    public void lastIsAMissOtherFrames() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeOtherNineFrames(match);
        match.throwBall(1);
        match.throwBall(1);
        score = score + 2;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }


    @Test
    public void lastIsStrike() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeNineFrames(match);
        match.throwBall(10);
        match.throwBall(10);
        match.throwBall(10);
        score = score + 10 + 10 + 10;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }

    @Test
    public void lastIsASpare() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeNineFrames(match);
        match.throwBall(5);
        match.throwBall(5);
        match.throwBall(8);
        score = score + 10 + 8;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }

    @Test
    public void lastIsAMiss() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeNineFrames(match);
        match.throwBall(1);
        match.throwBall(1);
        score = score + 2;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }
}