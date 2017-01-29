package com.bowling.mauriziopietrantuono.bowling.model.frame;


import com.bowling.mauriziopietrantuono.bowling.model.Ball;

public class MissFRame extends Frame {

    public MissFRame(Frame nextFrame, Ball firstBall, Ball secondBall) {
        super(nextFrame, firstBall, secondBall);
    }

    @Override
    public int calculateScore() {
        return firstBall.getScore() + secondBall.getScore();
    }

    @Override
    public Ball getNextBall() {
        return firstBall;
    }

    @Override
    public Ball getSecondNextBall() {
        return secondBall;
    }
}
