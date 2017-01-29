package com.bowling.mauriziopietrantuono.bowling.model;

import java.util.ArrayList;
import java.util.List;

public final class Match {
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
        int count = 20;
        for (int i = 0; i < balls.size() - 2; i++) {
            Ball ball = balls.get(i);
            if (ball.getScore() == 10) {
                count -= 2;
            } else {
                count--;
            }
        }
        return count > 0;
    }


}
