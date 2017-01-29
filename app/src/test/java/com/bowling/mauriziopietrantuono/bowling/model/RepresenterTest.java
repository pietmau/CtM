package com.bowling.mauriziopietrantuono.bowling.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepresenterTest {

    @Test
    public void when_TenStrikes_RightRepresenttion() throws InvalidPlayException {
        // GIVEN
        BowlingMatch bowlingMatch = new BowlingMatch();
        for (int i = 0; i < 12; i++) {
            bowlingMatch.throwBall(10);
        }
        //* WHEN
        String actual = new Representer().represent(bowlingMatch);
        String expected = "X|X|X|X|X|X|X|X|X|X||XX";
        assertEquals(expected, actual);
    }

    @Test
    public void when_TenSpares_RightRepresenttion() throws InvalidPlayException {
        // GIVEN
        BowlingMatch bowlingMatch = new BowlingMatch();
        for (int i = 0; i < 20; i++) {
            bowlingMatch.throwBall(5);
        }
        bowlingMatch.throwBall(5);
        //* WHEN
        String actual = new Representer().represent(bowlingMatch);
        String expected = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";
        assertEquals(expected, actual);
    }

    @Test
    public void when_AllMisses_RightRepresenttion() throws InvalidPlayException {
        // GIVEN
        BowlingMatch bowlingMatch = new BowlingMatch();
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                bowlingMatch.throwBall(9);
            }
            else{
                bowlingMatch.throwBall(0);
            }
        }
        //* WHEN
        String actual = new Representer().represent(bowlingMatch);
        String expected = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";
        assertEquals(expected, actual);
    }

    @Test
    public void when_SomeMatch_RightRepresenttion() throws InvalidPlayException {
        // GIVEN
        BowlingMatch bowlingMatch = new BowlingMatch();
        playTheMatch(bowlingMatch);
        //* WHEN
        String actual = new Representer().represent(bowlingMatch);
        String expected = "X|7/|9-|X|-8|8/|-6|X|X|X||81";
        assertEquals(expected, actual);
    }

    private void playTheMatch(BowlingMatch bowlingMatch) throws InvalidPlayException {
        bowlingMatch.throwBall(10);

        bowlingMatch.throwBall(7);
        bowlingMatch.throwBall(3);

        bowlingMatch.throwBall(9);
        bowlingMatch.throwBall(0);

        bowlingMatch.throwBall(10);

        bowlingMatch.throwBall(0);
        bowlingMatch.throwBall(8);

        bowlingMatch.throwBall(8);
        bowlingMatch.throwBall(2);

        bowlingMatch.throwBall(0);
        bowlingMatch.throwBall(6);

        bowlingMatch.throwBall(10);

        bowlingMatch.throwBall(10);

        bowlingMatch.throwBall(10);

        bowlingMatch.throwBall(8);
        bowlingMatch.throwBall(1);

    }
}