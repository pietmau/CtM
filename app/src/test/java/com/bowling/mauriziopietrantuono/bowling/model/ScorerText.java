package com.bowling.mauriziopietrantuono.bowling.model;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.bowling.mauriziopietrantuono.bowling.model.Helper.makeSomeNineFrames;
import static com.bowling.mauriziopietrantuono.bowling.model.Helper.makeSomeOtherNineFrames;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class ScorerText {

    @Test
    public void when_playFive_scoreIsFive() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.playBall(5);
        Scorer scorer = new Scorer();
        assertEquals(5, scorer.score(match));
    }

    @Test
    public void when_strike_scoreIsTen() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();
        // THEN
        match.playBall(10);
        Scorer scorer = new Scorer();
        assertEquals(10, scorer.score(match));
    }

    @Test
    public void when_strikeAndOtherTwoPlayes_scoreIsCorrect() throws InvalidPlayException {
        // GIVEN
        BowlingMatch match = new BowlingMatch();


        match.playBall(10);
        int firstFrameScore = 10 + 5 + 5;
        match.playBall(5);
        match.playBall(5);
        int secondFrameScore = 10;
        Scorer scorer = new Scorer();
        assertEquals(firstFrameScore + secondFrameScore, scorer.score(match));
    }

    @Test
    public void when_TwostrikeAndOtherTwoPlayes_scoreIsCorrect() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();

        //first frame
        match.playBall(10);
        int firstFrameScore = 10 + 10 + 5;
        // second frame
        match.playBall(10);
        int seconfFrameScore = 10 + 5 + 5;
        // third frame
        match.playBall(5);
        match.playBall(5);
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
        match.playBall(10);
        match.playBall(10);
        match.playBall(10);
        score = score + 10 + 10 + 10;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }

    @Test
    public void lastIsASpareOtherFrames() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeOtherNineFrames(match);
        match.playBall(5);
        match.playBall(5);
        match.playBall(8);
        score = score + 10 + 8;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }

    @Test
    public void lastIsAMissOtherFrames() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeOtherNineFrames(match);
        match.playBall(1);
        match.playBall(1);
        score = score + 2;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }


    @Test
    public void lastIsStrike() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeNineFrames(match);
        match.playBall(10);
        match.playBall(10);
        match.playBall(10);
        score = score + 10 + 10 + 10;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }

    @Test
    public void lastIsASpare() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeNineFrames(match);
        match.playBall(5);
        match.playBall(5);
        match.playBall(8);
        score = score + 10 + 8;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }

    @Test
    public void lastIsAMiss() throws InvalidPlayException {
        BowlingMatch match = new BowlingMatch();
        int score = makeSomeNineFrames(match);
        match.playBall(1);
        match.playBall(1);
        score = score + 2;
        Scorer scorer = new Scorer();
        assertEquals(score, scorer.score(match));
    }
}