package com.bowling.mauriziopietrantuono.bowling.model.frame;


import com.bowling.mauriziopietrantuono.bowling.model.Ball;

public abstract class Frame {
    public Frame nextFrame;
    public final Ball firstBall;
    public final Ball secondBall;

    public Frame(Ball firstBall, Ball secondBall) {
        this.firstBall = firstBall;
        this.secondBall = secondBall;
    }

    public abstract int calculateScore();

    public abstract Ball getNextBall();

    public abstract Ball getSecondNextBall();

    public Ball getSecondBall() {
        return secondBall;
    }

    public Ball getFirstBall() {
        return firstBall;
    }


}
