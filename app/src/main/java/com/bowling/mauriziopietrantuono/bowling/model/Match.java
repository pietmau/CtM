package com.bowling.mauriziopietrantuono.bowling.model;

import com.bowling.mauriziopietrantuono.bowling.model.frame.Frame;

public class Match {
    private Frame head = null;

    public void addFrame(Frame frame) {
        if (head == null) {
            head = frame;
            return;
        }
        checkMaxNumberOfFrames();
        appendFrame(frame);
    }

    private void appendFrame(Frame frame) {
        Frame temp = head;
        while (temp.nextFrame != null) {
            temp = temp.nextFrame;
        }
        temp.nextFrame = frame;
    }

    private void checkMaxNumberOfFrames() {
        Frame temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.nextFrame;
        }
        if (count > 10) {
            throw new IllegalArgumentException("Invalid match " + count + " frames!");
        }
    }

    private void checkMinNumberOfFrames() {
        Frame temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.nextFrame;
        }
        if (count < 10) {
            throw new IllegalArgumentException("Invalid match " + count + " frames!");
        }
    }

    public int calculate() {
        checkMinNumberOfFrames();
        return 0;
    }
}
