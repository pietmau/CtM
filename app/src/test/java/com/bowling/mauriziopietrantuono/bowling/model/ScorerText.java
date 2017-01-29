package com.bowling.mauriziopietrantuono.bowling.model;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class ScorerText {

    @Test
    public void when_playFive_scoreIsFive() throws InvalidPlayException {
        // GIVEN
        Match match = new Match();
        // THEN
        match.playBall(5);
        Scorer scorer = new Scorer(match);
        //assertEquals(5, scorer.score());
    }

    @Test
    public void when_strike_scoreIsTen() throws InvalidPlayException {
        // GIVEN
        Match match = new Match();
        // THEN
        match.playBall(10);
        Scorer scorer = new Scorer(match);
        assertEquals(10, scorer.score());
    }

    @Test
    public void when_strikeAndOtherTwoPlayes_scoreIsCorrect() throws InvalidPlayException {
        // GIVEN
        Match match = new Match();


        match.playBall(10);
        int firstFrameScore = 10 + 5 + 5;
        match.playBall(5);
        match.playBall(5);
        int secondFrameScore = 10;
        Scorer scorer = new Scorer(match);
        assertEquals(firstFrameScore + secondFrameScore, scorer.score());
    }

    @Test
    public void when_TwostrikeAndOtherTwoPlayes_scoreIsCorrect() throws InvalidPlayException {
        Match match = new Match();

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
        Scorer scorer = new Scorer(match);
        assertEquals(firstFrameScore + seconfFrameScore + thirdFrameScore, scorer.score());
    }

}