package com.bowling.mauriziopietrantuono.bowling.model;


import java.util.List;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_NUMBER_OF_FRAMES;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.SEPARATOR;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.SPARE;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.STRIKE;

public class Representer {
    private List<Ball> balls;

    public String represent(BowlingMatch match) {
        StringBuilder stringBuilder = new StringBuilder();
        balls = match.getBalls();
        for (int i = 0, frames = 0; i < balls.size() && frames < MAX_NUMBER_OF_FRAMES; i++, frames++) {

            if (isaStrike(i)) {
                stringBuilder.append(STRIKE);
                stringBuilder.append(SEPARATOR);
                continue;
            }

            if (isASpare(i)) {
                stringBuilder.append(balls.get(i).getScore());
                stringBuilder.append(SPARE);
                stringBuilder.append(SEPARATOR);
                i++;


            } else {
                stringBuilder.append(balls.get(i).getScore());
                i++;
                if (!isLastBall(i)) {
                    stringBuilder.append(balls.get(i).getScore());
                }
                stringBuilder.append(SEPARATOR);
            }
        }
        return stringBuilder.toString();
    }

    private boolean isLastBall(int i) {
        return (i >= balls.size());
    }


    private boolean isASpare(int i) {
        if (i > balls.size() - 2) {
            return false;
        }
        return (balls.get(i).getScore() + balls.get(i + 1).getScore()) == MAX_SCORE;
    }

    private boolean isaStrike(int index) {
        Ball ball = balls.get(index);
        return ball.getScore() == MAX_SCORE;
    }



}
