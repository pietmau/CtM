package com.bowling.mauriziopietrantuono.bowling.model;


import java.util.List;

public class Scorer {
    private final List<Ball> balls;

    public Scorer(Match match) {
        this.balls = match.getBalls();
    }

    public int score() {
        int score = 0;
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            if (ball.getScore() == Constants.MAX_SCORE) {
                score += Constants.MAX_SCORE;
                score += getNextTwoScores(i);
            }
        }
        return score;
    }

    private int getNextTwoScores(int i) {
        int nextTwoScores = 0;
        for (int j = i + 1; j < balls.size() && j < i + 3; j++) {
            nextTwoScores+=balls.get(j).getScore();
        }
        return nextTwoScores;
    }

}
