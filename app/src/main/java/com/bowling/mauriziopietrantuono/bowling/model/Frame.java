package com.bowling.mauriziopietrantuono.bowling.model;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;

public class Frame {
    Ball first;
    Ball second;

    public boolean isAStrike() {
        return first.getScore() == MAX_SCORE;
    }

    public boolean isASpare() {
        return (first.getScore() + second.getScore()) == MAX_SCORE;
    }

    public int getScore() {
        return (first.getScore() + second.getScore());
    }
}
