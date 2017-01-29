package com.bowling.mauriziopietrantuono.bowling.model;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

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
            match.throwBall(0);
            match.throwBall(0);
            try {
                // this should not be possible
                match.throwBall(0);
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
            match.throwBall(10);

            // this should be OK
            match.throwBall(5);
            match.throwBall(5);
        }
    }

    @Test
    public void when_lastStrike_then_IgetTwoOnly() throws InvalidPlayException {
        for (int i = 0; i < 100; i++) {
            BowlingMatch match = new BowlingMatch();
            // nine random plays
            makeNineRandomFrames(match);

            //last frame
            match.throwBall(10);

            // this should be OK
            match.throwBall(5);
            match.throwBall(5);

            try {
                // this should not be possible
                match.throwBall(5);
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
            match.throwBall(5);
            match.throwBall(5);
            // thsi should be possible
            match.throwBall(5);
        }
    }

    @Test
    public void give_randomPlay_when_lastSPare_then_IgetOneMore() throws InvalidPlayException {
        for (int i = 0; i < 100; i++) {
            BowlingMatch match = new BowlingMatch();
            // nine random plays
            makeNineRandomFrames(match);

            //last frame
            match.throwBall(5);
            match.throwBall(5);

            // this should be possible
            match.throwBall(5);
        }
    }


    @Test
    public void when_lastSPare_then_IgetOneMoreOnly() throws InvalidPlayException {
        for (int i = 0; i < 100; i++) {
            BowlingMatch match = new BowlingMatch();
            // nine random plays
            makeNineRandomFrames(match);

            // last frame
            match.throwBall(5);
            match.throwBall(5);

            // this should be OK
            match.throwBall(5);
            try {
                // this should not be possible
                match.throwBall(5);
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
            match.throwBall(5);
            match.throwBall(5);

            // this should be OK
            match.throwBall(5);
            try {
                // this should not be possible
                match.throwBall(5);
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
                match.throwBall(10);
            }
            if (rand == 1) {
                match.throwBall(5);
                match.throwBall(5);
            }
            if (rand == 2) {
                match.throwBall(random.nextInt(5));
                match.throwBall(random.nextInt(5));
            }
        }
    }

}