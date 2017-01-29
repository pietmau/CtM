package com.bowling.mauriziopietrantuono.bowling.model;


import java.util.ArrayList;
import java.util.List;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_NUMBER_OF_FRAMES;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;

/**
 * Calculates the score of a match
 */
public class Scorer {
    private final List<Ball> balls = new ArrayList<>();

    public int score(BowlingMatch match) {
        getBalls(match);
        int score = 0;

        for (int i = 0, frames = 0; i < balls.size() && frames < MAX_NUMBER_OF_FRAMES; i++, frames++) {

            if (isaStrike(i)) {
                score += scoreStrike(i);
                continue;
            }

            if (isASpare(i)) {
                score += scoreSpare(i);

            } else {
                score += scoreMiss(i);
            }
            i++;
        }
        return score;
    }

    private boolean isaStrike(int index) {
        return balls.get(index).getScore() == MAX_SCORE;
    }

    private int scoreStrike(int i) {
        return MAX_SCORE + getNextTwoScores(i);
    }

    private int getNextTwoScores(int i) {
        int nextTwoScores = 0;
        for (int j = i + 1; j < balls.size() && j < i + 3; j++) {
            nextTwoScores += balls.get(j).getScore();
        }
        return nextTwoScores;
    }

    private boolean isASpare(int i) {
        if (i > balls.size() - 2) {
            return false;
        }
        return (balls.get(i).getScore() + balls.get(i + 1).getScore()) == MAX_SCORE;
    }

    private int scoreSpare(int i) {
        return MAX_SCORE + getNextScore(i);
    }

    private int scoreMiss(int i) {
        int score = 0;
        score += balls.get(i).getScore();

        if (!isLastBall(i + 1)) {
            score += balls.get(i + 1).getScore();
        }
        return score;
    }

    private int getNextScore(int i) {
        if (i >= balls.size() - 2) {
            return 0;
        }
        return balls.get(i + 2).getScore();
    }

    private boolean isLastBall(int i) {
        return i >= balls.size();
    }


    private void getBalls(BowlingMatch match) {
        balls.clear();
        for (Frame frame : match.getFrames()) {
            balls.add(frame.first);
            if (frame.second != null) {
                balls.add(frame.second);
            }
        }
        for (Bonus bonus : match.getBonuses()) {
            balls.add(bonus.ball);
        }
        if (match.getCurrentGame().firstBall != null) {
            balls.add(match.getCurrentGame().firstBall);
        }
    }

}
