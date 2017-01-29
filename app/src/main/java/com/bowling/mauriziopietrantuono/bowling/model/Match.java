package com.bowling.mauriziopietrantuono.bowling.model;

import com.bowling.mauriziopietrantuono.bowling.model.frame.Frame;

public class Match {
    private Frame head = null;

    private boolean addFrame(Frame frame) {
        if (head == null) {
            head = frame;
            return true;
        }
        checkMaxNumberOfFrames();
        return appendFrame(frame);
    }

    private boolean appendFrame(Frame frame) {
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
