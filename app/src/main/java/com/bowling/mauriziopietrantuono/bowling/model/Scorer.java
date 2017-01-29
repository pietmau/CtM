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

        for (int framesIndex = 0; framesIndex < frames.size(); framesIndex++) {
            if (frames.get(framesIndex).isAStrike()) {
                score += MAX_SCORE;
                score += getNextTwoScores(framesIndex);
                continue;
            }
            if (frames.get(framesIndex).isASpare()) {
                score += MAX_SCORE;
                score += getNextScore(framesIndex);
                continue;
            }
            score += frames.get(framesIndex).getScore();
        }
        return score;
    }


    private int getNextTwoScores(int framesIndex) {
        int score = 0;
        if (framesIndex > (frames.size() + bonuses.size()) - 1) {
            return score;
        }
        if (framesIndex < frames.size() - 2) {
            score += getNextTwoFramesScores(framesIndex);
            return score;
        }

        if (framesIndex < frames.size() - 1) {
            score += getNextScore(framesIndex);
        }
        return score;
    }

    private int getNextTwoFramesScores(int framesIndex) {
        int score = 0;
        if (!frames.get(framesIndex + 1).isAStrike()) {
            score += frames.get(framesIndex + 1).getScore();
            return score;
        }
        score += MAX_SCORE;
        framesIndex++;
        score += getNextScore(framesIndex);
        return score;
    }

    private int getNextScore(int framesIndex) {
        if (framesIndex < frames.size() - 1) {
            return frames.get(framesIndex + 1).first.getScore();
        }
        if (framesIndex < frames.size() + bonuses.size() - 1) {
            return bonuses.get((framesIndex + 1) - frames.size()).getScore();
        }
        return 0;
    }

}
