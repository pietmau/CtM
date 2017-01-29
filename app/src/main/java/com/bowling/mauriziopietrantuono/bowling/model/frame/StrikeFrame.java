package com.bowling.mauriziopietrantuono.bowling.model.frame;


import com.bowling.mauriziopietrantuono.bowling.model.Ball;

public class StrikeFrame extends Frame {

    public StrikeFrame() {
        super(new Ball(10), null);
    }

    @Override
    public int calculateScore() {
        return firstBall.getScore() + nextFrame.getFirstBall().getScore() + nextFrame.getSecondNextBall().getScore();
    }

    @Override
    public Ball getNextBall() {
        return firstBall;
    }

    @Override
    public Ball getSecondNextBall() {
        return nextFrame.getNextBall();
    }
}
