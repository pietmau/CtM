package com.bowling.mauriziopietrantuono.bowling.model.frame;


import com.bowling.mauriziopietrantuono.bowling.model.Ball;

public class BonusFrame extends Frame {

    public BonusFrame(Ball firstBall, Ball secondBall) {
        super(firstBall, secondBall);
    }

    @Override
    public int calculateScore() {
        throw new UnsupportedOperationException("This is a bonus!");
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
