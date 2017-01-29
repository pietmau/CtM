package com.bowling.mauriziopietrantuono.bowling.model.frame;


import com.bowling.mauriziopietrantuono.bowling.model.Ball;

public class SpareFrame extends Frame {

    public SpareFrame(Frame nextFrame, Ball firstBall, Ball secondBall) {
        super(firstBall, secondBall);
    }

    @Override
    public int calculateScore() {
        return firstBall.getScore() + secondBall.getScore() + nextFrame.getNextBall().getScore();
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
