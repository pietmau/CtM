package com.bowling.mauriziopietrantuono.bowling.model;

import java.util.ArrayList;
import java.util.List;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_NUMBER_OF_FRAMES;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;
import static java.util.Collections.unmodifiableList;

public class BowlingMatch {
    private final List<Ball> balls = new ArrayList<>();

    public void playBall(int score) throws InvalidPlayException {
        if (score < 0 || score > 10) {
            throw new InvalidPlayException("Invalid play");
        }
        checkBalls();
        balls.add(new Ball(score));
    }

    private void checkBalls() throws InvalidPlayException {
        if (!canPlayNext()) {
            throw new InvalidPlayException(balls.size());
        }
    }

    private boolean canPlayNext() {
        int numberOfFrames = 0;
        int currentBall = 0;

        for (; currentBall < balls.size() && numberOfFrames < MAX_NUMBER_OF_FRAMES; currentBall++) {
            if (isAStrike(currentBall)) {
                numberOfFrames++;
            } else {
                if (!isTheLastBall(currentBall)) {
                    numberOfFrames++;
                    currentBall++;
                }
            }
        }
        if (numberOfFrames < MAX_NUMBER_OF_FRAMES) {
            return true;
        }

        if (isLastFrameAStrike(currentBall)) {
            return (balls.size() - currentBall + 1) <= 2;
        }

        if (isLastFrameASpare(currentBall)) {
            return (balls.size() - currentBall + 1) <= 1;
        }

        return false;
    }

    private boolean isTheLastBall(int currentBall) {
        return (currentBall >= balls.size() - 1);
    }

    private boolean isAStrike(int currentBall) {
        return balls.get(currentBall).getScore() == MAX_SCORE;
    }

    private boolean isLastFrameAStrike(int currentBall) {
        return isAStrike(currentBall - 1);
    }

    private boolean isLastFrameASpare(int currentBall) {
        int latsPlay = balls.get(currentBall - 1).getScore();
        int secondLastplay = balls.get(currentBall - 2).getScore();
        return (latsPlay + secondLastplay) == MAX_SCORE;
    }

    public List<Ball> getBalls() {
        return unmodifiableList(balls);
    }
}
