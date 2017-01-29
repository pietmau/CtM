package com.bowling.mauriziopietrantuono.bowling.model;


import java.util.List;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_NUMBER_OF_FRAMES;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.SEPARATOR;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.SPARE;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.STRIKE;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.ZERO;

public class Representer {
    private List<Ball> balls;

    public String represent(BowlingMatch match) {
        StringBuilder stringBuilder = new StringBuilder();
        balls = match.getBalls();
        int i = 0, frames = 0;

        for (; i < balls.size() && frames < MAX_NUMBER_OF_FRAMES; i++, frames++) {
            if (isaStrike(i)) {
                appendStrike(stringBuilder);
                continue;
            }
            if (isASpare(i)) {
                appendSpare(stringBuilder, i);
                i++;
            } else {
                if (balls.get(i).getScore() != 0) {
                    stringBuilder.append(balls.get(i).getScore());
                } else{
                    stringBuilder.append(ZERO);
                }
                i++;
                if (!isLastBall(i)) {
                    if (balls.get(i).getScore() != 0) {
                        stringBuilder.append(balls.get(i).getScore());
                    } else{
                        stringBuilder.append(ZERO);
                    }
                }
                stringBuilder.append(SEPARATOR);
            }
        }
        stringBuilder.append(SEPARATOR);

        if (i < balls.size()) {
            for (int j = i; j < balls.size(); j++) {
                if (balls.get(j).getScore() == 10) {
                    stringBuilder.append(STRIKE);
                } else {
                    stringBuilder.append(balls.get(j).getScore());
                }
            }
        }

        return stringBuilder.toString();
    }

    private void appendSpare(StringBuilder stringBuilder, int i) {
        stringBuilder.append(balls.get(i).getScore());
        stringBuilder.append(SPARE);
        stringBuilder.append(SEPARATOR);
    }

    private void appendStrike(StringBuilder stringBuilder) {
        stringBuilder.append(STRIKE);
        stringBuilder.append(SEPARATOR);
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
