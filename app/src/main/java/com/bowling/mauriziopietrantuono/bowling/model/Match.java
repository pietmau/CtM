package com.bowling.mauriziopietrantuono.bowling.model;

import com.bowling.mauriziopietrantuono.bowling.model.frame.Frame;
import com.bowling.mauriziopietrantuono.bowling.model.frame.StrikeFrame;

public final class Match {
    Frame head = null;

    private void addFrame(Frame frame) {
        if (head == null) {
            head = frame;
            return;
        }
        checkMaxNumberOfFrames();
        appendFrame(frame);
    }

    public boolean playBall(int score) {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("Invalid play");
        }
        if (score == 10) {
            addStrike();
        }
        return true;
    }

    private void addStrike() {
        if (head == null) {
            head = new StrikeFrame();
        } else {
            head.nextFrame = new StrikeFrame();
        }
    }

    private void appendFrame(Frame frame) {
        Frame temp = head;
        while (temp.nextFrame != null) {
            temp = temp.nextFrame;
        }
        temp.nextFrame = frame;
    }

    private void checkMaxNumberOfFrames() {
        int count = getCountOfFrames();
        if (count > 10) {
            throw new IllegalArgumentException("Invalid match " + count + " frames!");
        }
    }

    private int getCountOfFrames() {
        Frame temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.nextFrame;
        }
        return count;
    }

    private void checkMinNumberOfFrames() {
        int count = getCountOfFrames();
        if (count < 10) {
            throw new IllegalArgumentException("Invalid match " + count + " frames!");
        }
    }

    public int calculate() {
        checkMinNumberOfFrames();
        return 0;
    }
}
