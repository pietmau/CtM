package com.bowling.mauriziopietrantuono.bowling.model;


class Helper {

    public static int makeSomeNineFrames(BowlingMatch match) throws InvalidPlayException {
        int score = 0;

        match.throwBall(10);
        score = 20;

        match.throwBall(5);
        match.throwBall(5);
        score = 40;

        match.throwBall(10);
        score = 50;

        match.throwBall(0);
        match.throwBall(0);
        score = 50;

        match.throwBall(10);
        score = 70;

        match.throwBall(5);
        match.throwBall(5);
        score = 80;

        match.throwBall(0);
        match.throwBall(0);
        score = 80;

        match.throwBall(10);
        score = 97;

        match.throwBall(4);
        match.throwBall(3);
        score = 104;
        return score;
    }

    public static int makeSomeOtherNineFrames(BowlingMatch match) throws InvalidPlayException {
        int score = 0;

        match.throwBall(1);
        match.throwBall(4);
        score = 5;

        match.throwBall(1);
        match.throwBall(9);
        score = score + 10 + 10;

        match.throwBall(10);
        score = score + 10 + 10;

        match.throwBall(5);
        match.throwBall(5);
        score = score + 10 + 0;

        match.throwBall(0);
        match.throwBall(3);
        score = score + 3;

        match.throwBall(5);
        match.throwBall(5);
        score = score + 10 + 0;

        match.throwBall(0);
        match.throwBall(0);
        score = score + 0;

        match.throwBall(5);
        match.throwBall(5);
        score = score + 10 + 4;

        match.throwBall(4);
        match.throwBall(3);
        score = score + 4 + 3;
        return score;
    }
}
