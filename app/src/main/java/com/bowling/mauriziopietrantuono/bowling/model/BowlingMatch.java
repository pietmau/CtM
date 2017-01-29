package com.bowling.mauriziopietrantuono.bowling.model;

import java.util.ArrayList;
import java.util.List;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_NUMBER_OF_FRAMES;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;

public class BowlingMatch {
    private List<Frame> frames = new ArrayList<>();
    private List<Bonus> bonuses = new ArrayList<>();
    int numberOfBounusesReceived = 0;
    private Game currentGame = new Game();

    public void throwBall(int score) throws InvalidPlayException {
        if (score < 0 || score > 10) {
            throw new InvalidPlayException("Invalid throw " + score);
        }
        checkNumberOfFramesAndBounuses();

        if (playingNomalFrames()) {
            playNormalFrame(score);
            return;
        } else if (playingBonuses()) {
            playBonuses(score);
            return;
        }
        throw new RuntimeException("We should not be here");
    }

    private void playBonuses(int score) {
        bonuses.add(new Bonus(score));
    }

    private void playNormalFrame(int score) throws InvalidPlayException {
        checkCurrentGame(score);
        playGame(score);
    }

    private void playGame(int score) {
        if (score == MAX_SCORE) {
            currentGame = new Game();
            Frame frame = new Frame();
            frame.first = new Ball(score);
            frames.add(frame);
            if (islastFrame()) {
                if (lastFrameIsAStrike()) {
                    numberOfBounusesReceived = 2;
                } else if (lastFrameIsASpare()) {
                    numberOfBounusesReceived = 1;
                }
            }
            return;
        }
        currentGame.setBall(new Ball(score));

        if (currentGame.isFinished()) {
            Frame frame = new Frame();
            frame.first = currentGame.firstBall;
            frame.second = currentGame.secondBall;
            frames.add(frame);
            currentGame = new Game();
            if (islastFrame()) {
                if (lastFrameIsAStrike()) {
                    numberOfBounusesReceived = 2;
                } else if (lastFrameIsASpare()) {
                    numberOfBounusesReceived = 1;
                }
            }
        }

    }

    private boolean lastFrameIsASpare() {
        return (frames.get(MAX_NUMBER_OF_FRAMES - 1).first.getScore() + frames.get(MAX_NUMBER_OF_FRAMES - 1).second.getScore()) == MAX_SCORE;
    }

    private boolean lastFrameIsAStrike() {
        return frames.get(MAX_NUMBER_OF_FRAMES - 1).first.getScore() == MAX_SCORE;
    }

    private boolean islastFrame() {
        return frames.size() == MAX_NUMBER_OF_FRAMES;
    }

    private void checkCurrentGame(int score) throws InvalidPlayException {
        int lastTwo = currentGame.getScore() + score;
        if (lastTwo > MAX_SCORE) {
            throw new InvalidPlayException("Last two throws = " + lastTwo);
        }
    }

    private boolean playingBonuses() {
        return bonuses.size() < numberOfBounusesReceived;
    }

    private boolean playingNomalFrames() {
        return frames.size() < MAX_NUMBER_OF_FRAMES;
    }

    private void checkNumberOfFramesAndBounuses() throws InvalidPlayException {
        if (frames.size() + bonuses.size() >= (MAX_NUMBER_OF_FRAMES + numberOfBounusesReceived)) {
            throw new InvalidPlayException("Your match is ended");
        }
    }


}
