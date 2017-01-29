package com.bowling.mauriziopietrantuono.bowling.model;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;

public class Frame {
    Ball first;
    Ball second;

    public int getScore() {
        return first.getScore() + second.getScore();
    }
}
