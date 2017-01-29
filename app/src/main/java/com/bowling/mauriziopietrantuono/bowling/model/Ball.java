package com.bowling.mauriziopietrantuono.bowling.model;


class Ball {
    private final int score;

    public Ball(int score) {
        if (score > 10 || score < 0) {
            throw new IllegalArgumentException("Ball is min 0 max 10");
        }
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
