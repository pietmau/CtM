package com.bowling.mauriziopietrantuono.bowling.model;

import java.util.ArrayList;
import java.util.List;

public final class Match {
    private static final int MAX_BALLS_COUNT = 22;
    List<Ball> balls = new ArrayList<>();

    public boolean playBall(int score) throws InvalidPlayException {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("Invalid play");
        }
        checkBalls();
        balls.add(new Ball(score));
        return true;
    }

    private void checkBalls() throws InvalidPlayException {
        int count = balls.size();
        if (count >= 22) {
            throw new InvalidPlayException(balls.size());
        }
        if (!canPlayNext()) {
            throw new InvalidPlayException(balls.size());
        }
    }

    private boolean canPlayNext() {
        int numberOfFrames = 0;
        int currentBall = 0;
        for (; currentBall < balls.size() && numberOfFrames < 10; currentBall++) {
            if (balls.get(currentBall).getScore() == 10) {
                numberOfFrames++;
                continue;
            } else {
                if (currentBall < balls.size() - 1) {
                    numberOfFrames++;
                    currentBall++;
                }
            }
        }
        if (numberOfFrames < 10) {
            return true;
        }

        if (balls.get(currentBall - 1).getScore() == 10) {
            return (balls.size() - currentBall + 1) <= 2;
        }

        int latsPlay = balls.get(currentBall - 1).getScore();
        int secondLastplay = balls.get(currentBall - 2).getScore();

        if ((latsPlay + secondLastplay) == 10) {
            return (balls.size() - currentBall + 1) <= 1;
        }

        return false;
    }


}
