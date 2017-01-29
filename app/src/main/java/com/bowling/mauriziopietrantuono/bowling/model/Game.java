package com.bowling.mauriziopietrantuono.bowling.model;

public class Game {
    Ball firstBall;
    Ball secondBall;

    int getScore() {
        int score = 0;
        if (firstBall != null) {
            score = firstBall.getScore();
        }
        if (secondBall != null) {
            score = secondBall.getScore();
        }
        return score;
    }

    boolean isFinished() {
        return firstBall != null && secondBall != null;
    }

    void setBall(Ball ball) {
        if (firstBall == null) {
            firstBall = ball;
            return;
        }
        if (secondBall == null) {
            secondBall = ball;
            return;
        }
        new RuntimeException();
    }
}
