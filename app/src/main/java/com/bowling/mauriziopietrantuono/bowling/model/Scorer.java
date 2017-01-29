package com.bowling.mauriziopietrantuono.bowling.model;


import java.util.List;

public class Scorer {
    private final List<Ball> balls;

    public Scorer(Match match) {
        this.balls = match.getBalls();
    }

    public int score() {
        int score = 0;
        for (Ball ball : balls) {
            score += ball.getScore();
        }
        return score;
    }
}
