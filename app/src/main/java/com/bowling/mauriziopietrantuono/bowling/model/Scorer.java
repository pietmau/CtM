package com.bowling.mauriziopietrantuono.bowling.model;


import java.util.List;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_NUMBER_OF_FRAMES;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;

public class Scorer {
    private List<Frame> frames;
    private List<Bonus> bonuses;

    public int score(BowlingMatch match) {
        int score = 0;
        frames = match.getFrames();
        bonuses = match.getBonuses();

        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i).isAStrike()) {
                score += MAX_SCORE;
                score += getNextTwoScores(i);
                continue;
            }
            if (frames.get(i).isASpare()) {
                score += MAX_SCORE;
                score += getNextScore(i);
                continue;
            }
            score += frames.get(i).getScore();
        }
        return score;
    }

    private int getNextScore(int i) {
        return 0;
    }

    private int getNextTwoScores(int i) {
        return 0;
    }


}
