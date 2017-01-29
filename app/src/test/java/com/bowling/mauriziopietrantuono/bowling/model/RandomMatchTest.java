package com.bowling.mauriziopietrantuono.bowling.model;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class RandomMatchTest {

    @Test
    public void when_lastNotStrikeOrSpare_then_fails() throws InvalidPlayException {
        for (int i = 0; i < 100; i++) {
            BowlingMatch match = new BowlingMatch();
            // nine random plays
            makeNineRandomFrames(match);

            // last Frame
            match.playBall(0);
            match.playBall(0);
            try {
                // this should not be possible
                match.playBall(0);
                fail();
            } catch (InvalidPlayException e) {
            }
        }
    }

    @Test
    public void when_lastStrike_then_IgetTwo() throws InvalidPlayException {
        for (int i = 0; i < 100; i++) {
            BowlingMatch match = new BowlingMatch();
            // nine random plays
            makeNineRandomFrames(match);
            //last frame
            match.playBall(10);

            // this should be OK
            assertTrue(match.playBall(5));
            assertTrue(match.playBall(5));
        }
    }

    @Test
    public void when_lastStrike_then_IgetTwoOnly() throws InvalidPlayException {
        for (int i = 0; i < 100; i++) {
            BowlingMatch match = new BowlingMatch();
            // nine random plays
            makeNineRandomFrames(match);

            //last frame
            match.playBall(10);

            // this should be OK
            assertTrue(match.playBall(5));
            assertTrue(match.playBall(5));

            try {
                // this should not be possible
                assertTrue(match.playBall(5));
                fail();
            } catch (InvalidPlayException e) {
            }
        }
    }

    @Test
    public void when_lastSPare_then_IgetOneMore() throws InvalidPlayException {
        for (int i = 0; i < 100; i++) {
            BowlingMatch match = new BowlingMatch();
            // nine random plays
            makeNineRandomFrames(match);

            //last frame
            assertTrue(match.playBall(5));
            assertTrue(match.playBall(5));
            // thsi should be possible
            assertTrue(match.playBall(5));
        }
    }

    @Test
    public void give_randomPlay_when_lastSPare_then_IgetOneMore() throws InvalidPlayException {
        for (int i = 0; i < 100; i++) {
            BowlingMatch match = new BowlingMatch();
            // nine random plays
            makeNineRandomFrames(match);

            //last frame
            assertTrue(match.playBall(5));
            assertTrue(match.playBall(5));

            // this should be possible
            assertTrue(match.playBall(5));
        }
    }


    @Test
    public void when_lastSPare_then_IgetOneMoreOnly() throws InvalidPlayException {
        for (int i = 0; i < 100; i++) {
            BowlingMatch match = new BowlingMatch();
            // nine random plays
            makeNineRandomFrames(match);

            // last frame
            assertTrue(match.playBall(5));
            assertTrue(match.playBall(5));

            // this should be OK
            assertTrue(match.playBall(5));
            try {
                // this should not be possible
                assertTrue(match.playBall(5));
                fail();
            } catch (InvalidPlayException e) {
            }
        }
    }

    @Test
    public void givern_Random_matchwhen_lastSPare_then_IgetOneMoreOnly() throws InvalidPlayException {
        for (int i = 0; i < 100; i++) {
            BowlingMatch match = new BowlingMatch();
            // nine random plays
            makeNineRandomFrames(match);

            //last frame
            assertTrue(match.playBall(5));
            assertTrue(match.playBall(5));

            // this should be OK
            assertTrue(match.playBall(5));
            try {
                // this should not be possible
                assertTrue(match.playBall(5));
                fail();
            } catch (InvalidPlayException e) {
            }
        }
    }


    private void makeNineRandomFrames(BowlingMatch match) throws InvalidPlayException {
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            int rand = random.nextInt(3);
            if (rand == 0) {
                match.playBall(10);
            }
            if (rand == 1) {
                match.playBall(5);
                match.playBall(5);
            }
            if (rand == 2) {
                match.playBall(random.nextInt(5));
                match.playBall(random.nextInt(5));
            }
        }
    }

}