package com.bowling.mauriziopietrantuono.bowling.model;


public class Helper {

    public static int makeSomeNineFrames(BowlingMatch match) throws InvalidPlayException {
        int score = 0;

        match.playBall(10);
        score = 20;

        match.playBall(5);
        match.playBall(5);
        score = 40;

        match.playBall(10);
        score = 50;

        match.playBall(0);
        match.playBall(0);
        score = 50;

        match.playBall(10);
        score = 70;

        match.playBall(5);
        match.playBall(5);
        score = 80;

        match.playBall(0);
        match.playBall(0);
        score = 80;

        match.playBall(10);
        score = 97;

        match.playBall(4);
        match.playBall(3);
        score = 104;
        return score;
    }

    public static int makeSomeOtherNineFrames(BowlingMatch match) throws InvalidPlayException {
        int score = 0;

        match.playBall(1);
        match.playBall(4);
        score = 5;

        match.playBall(1);
        match.playBall(9);
        score = score + 10 + 10;

        match.playBall(10);
        score = score + 10 + 10;

        match.playBall(5);
        match.playBall(5);
        score = score + 10 + 0;

        match.playBall(0);
        match.playBall(3);
        score = score + 3;

        match.playBall(5);
        match.playBall(5);
        score = score + 10 + 0;

        match.playBall(0);
        match.playBall(0);
        score = score + 0;

        match.playBall(5);
        match.playBall(5);
        score = score + 10 + 4;

        match.playBall(4);
        match.playBall(3);
        score = score + 4 + 3;
        return score;
    }
}
