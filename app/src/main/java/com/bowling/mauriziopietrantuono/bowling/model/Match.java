package com.bowling.mauriziopietrantuono.bowling.model;

import com.bowling.mauriziopietrantuono.bowling.model.frame.Frame;
import com.bowling.mauriziopietrantuono.bowling.model.frame.SpareFrame;
import com.bowling.mauriziopietrantuono.bowling.model.frame.StrikeFrame;

import java.util.ArrayList;
import java.util.List;

public final class Match {
    List<Frame> frames = new ArrayList<>();

    public boolean playBall(int score) {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("Invalid play");
        }
        if (score == 10) {
            addStrike();
        }
        addSpareOrMiss(score);
        return true;
    }

    private void addSpareOrMiss(int score) {
        frames.add(new SpareFrame(score, 0));
    }


    private void addStrike() {
        frames.add(new StrikeFrame());
    }

}
