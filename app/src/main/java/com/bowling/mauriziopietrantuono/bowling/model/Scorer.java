package com.bowling.mauriziopietrantuono.bowling.model;


import java.util.List;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_NUMBER_OF_FRAMES;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;

public class Scorer {
    private final List<Ball> balls;

    public Scorer(Match match) {
        this.balls = match.getBalls();
    }

    public int score() {
        int score = 0;
        int frames = 0;

        for (int i = 0; i < balls.size() && frames < MAX_NUMBER_OF_FRAMES; i++, frames++) {

            if (isaStrike(i)) {
                score += MAX_SCORE;
                score += getNextTwoScores(i);
                continue;
            }

            if (isASpare(i)) {
                score += MAX_SCORE;
                i++;
                score += getNextScore(i);
                continue;

            } else {
                score += balls.get(i).getScore();
                i++;
                if (i < balls.size()) {
                    score += balls.get(i).getScore();
                }
            }
        }
        if(frames<MAX_NUMBER_OF_FRAMES){
            return score;
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
        boolean b = (balls.get(i).getScore() + balls.get(i + 1).getScore()) == MAX_SCORE;

        return b;
    }

    private boolean isaStrike(int index) {
        Ball ball = balls.get(index);
        return ball.getScore() == MAX_SCORE;
    }

    private int getNextTwoScores(int i) {
        int nextTwoScores = 0;
        for (int j = i + 1; j < balls.size() && j < i + 3; j++) {
            nextTwoScores += balls.get(j).getScore();
        }
        return nextTwoScores;
    }

}
