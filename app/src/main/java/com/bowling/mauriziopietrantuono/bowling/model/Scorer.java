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

            if (isaStrike(i)) {
                score += Constants.MAX_SCORE;
                score += getNextTwoScores(i);
                continue;
            }

            if (isASpare(i)) {
                score += Constants.MAX_SCORE;
                i++;
                score += getNextScore(i);
                continue;
            }
            score += balls.get(i).getScore();

        }
        return score;
    }

    private int getNextScore(int i) {
        if (i >= balls.size() - 1) {
            return 0;
        }
        return balls.get(i + 1).getScore();
    }

    private boolean isASpare(int i) {
        if (i > balls.size() - 2) {
            return false;
        }
        return (balls.get(i).getScore() + balls.get(i + 1).getScore()) == Constants.MAX_SCORE;
    }

    private boolean isaStrike(int index) {
        Ball ball = balls.get(index);
        return ball.getScore() == Constants.MAX_SCORE;
    }

    private int getNextTwoScores(int i) {
        int nextTwoScores = 0;
        for (int j = i + 1; j < balls.size() && j < i + 3; j++) {
            nextTwoScores += balls.get(j).getScore();
        }
        return nextTwoScores;
    }

}
