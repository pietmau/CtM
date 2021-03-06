package com.bowling.mauriziopietrantuono.bowling.model;


import java.util.ArrayList;
import java.util.List;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_NUMBER_OF_FRAMES;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.SEPARATOR;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.SPARE;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.STRIKE;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.ZERO;

/**
 * Represents a match as a string
 */
public class Representer {
    private final List<Ball> balls = new ArrayList<>();

    public String represent(BowlingMatch match) {
        StringBuilder stringBuilder = new StringBuilder();
        getBalls(match);
        if (balls.isEmpty()) {
            return stringBuilder.toString();
        }
        int currentBall = 0;

        currentBall = appendRegularFrames(stringBuilder, currentBall);

        stringBuilder.append(SEPARATOR);

        appendBonusFrames(stringBuilder, currentBall);
        return stringBuilder.toString();
    }


    private void appendBonusFrames(StringBuilder stringBuilder, int currentBall) {
        if (currentBall < balls.size()) {
            for (int j = currentBall; j < balls.size(); j++) {
                if (balls.get(j).getScore() == 10) {
                    stringBuilder.append(STRIKE);
                } else {
                    stringBuilder.append(balls.get(j).getScore());
                }
            }
        }
    }

    private int appendRegularFrames(StringBuilder stringBuilder, int i) {
        for (int frames = 0; i < balls.size() && frames < MAX_NUMBER_OF_FRAMES; i++, frames++) {
            if (isaStrike(i)) {
                appendStrike(stringBuilder);
                continue;
            }
            if (isASpare(i)) {
                appendSpare(stringBuilder, i);
                i++;
            } else {
                appendNumberOrDash(stringBuilder, i);
                i++;
                if (!isLastBall(i)) {
                    appendNumberOrDash(stringBuilder, i);
                }
                stringBuilder.append(SEPARATOR);
            }
        }
        return i;
    }

    private void appendNumberOrDash(StringBuilder stringBuilder, int i) {
        if (balls.get(i).getScore() != 0) {
            stringBuilder.append(balls.get(i).getScore());
        } else {
            stringBuilder.append(ZERO);
        }
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
        return i >= balls.size();
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
