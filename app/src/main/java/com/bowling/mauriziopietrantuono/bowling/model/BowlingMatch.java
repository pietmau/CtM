package com.bowling.mauriziopietrantuono.bowling.model;

import java.util.ArrayList;
import java.util.List;

import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_NUMBER_OF_FRAMES;
import static com.bowling.mauriziopietrantuono.bowling.model.Constants.MAX_SCORE;

public class BowlingMatch {
    private final List<Frame> frames = new ArrayList<>();
    private final List<Bonus> bonuses = new ArrayList<>();
    int numberOfBounusesReceived = 0;
    private Game currentGame = new Game();

    public void throwBall(int score) throws InvalidPlayException {
        if (score < 0 || score > 10) {
            throw new InvalidPlayException("Invalid throw " + score);
        }

        checkNumberOfFramesAndBounuses();

        if (!playingBonuses()) {
            playNormalFrame(score);
        } else {
            playBonuses(score);
        }
    }

    /**
     * Checks if we are non exceeding the frames and bonuses that we have
     */
    private void checkNumberOfFramesAndBounuses() throws InvalidPlayException {
        if (frames.size() + bonuses.size() >= (MAX_NUMBER_OF_FRAMES + numberOfBounusesReceived)) {
            throw new InvalidPlayException("Your match is ended");
        }
    }

    /**
     * Plays the current ball
     */
    private void playNormalFrame(int score) throws InvalidPlayException {
        checkCurrentGame(score);
        playGame(score);
    }

    /**
     * Checks if the input is valid  (if we are not scoring more than 10 in a single frame )
     */
    private void checkCurrentGame(int score) throws InvalidPlayException {
        int lastTwo = currentGame.getScore() + score;
        if (lastTwo > MAX_SCORE) {
            throw new InvalidPlayException("Last two throws = " + lastTwo);
        }
    }

    /**
     * Actually plays the ball: updates current game, frames and bonuses accordingly
     */
    private void playGame(int score) {
        if (score == MAX_SCORE) {
            currentGame = new Game();
            Frame frame = new Frame();
            frame.first = new Ball(score);
            frames.add(frame);
            updateBonuses();
            return;
        }
        currentGame.setBall(new Ball(score));

        if (currentGame.isFinished()) {
            Frame frame = new Frame();
            frame.first = currentGame.firstBall;
            frame.second = currentGame.secondBall;
            frames.add(frame);
            currentGame = new Game();
            updateBonuses();
        }
    }

    /** Returns true if we are playing bonuses */
    private boolean playingBonuses() {
        return bonuses.size() < numberOfBounusesReceived;
    }

    /**
     * Plays a bonus ball
     */
    private void playBonuses(int score) {
        bonuses.add(new Bonus(score));
    }

    /** Updates the bonuses */
    private void updateBonuses() {
        if (isLastFrame()) {
            if (lastFrameIsAStrike()) {
                numberOfBounusesReceived = 2;
            } else if (lastFrameIsASpare()) {
                numberOfBounusesReceived = 1;
            }
        }
    }

    private boolean lastFrameIsASpare() {
        return (frames.get(MAX_NUMBER_OF_FRAMES - 1).first.getScore() + frames.get(MAX_NUMBER_OF_FRAMES - 1).second.getScore()) == MAX_SCORE;
    }

    private boolean lastFrameIsAStrike() {
        return frames.get(MAX_NUMBER_OF_FRAMES - 1).first.getScore() == MAX_SCORE;
    }

    private boolean isLastFrame() {
        return frames.size() == MAX_NUMBER_OF_FRAMES;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public Game getCurrentGame() {
        return currentGame;
    }
}
