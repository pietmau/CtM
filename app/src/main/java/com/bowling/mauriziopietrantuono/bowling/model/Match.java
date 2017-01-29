package com.bowling.mauriziopietrantuono.bowling.model;

import com.bowling.mauriziopietrantuono.bowling.model.frame.Frame;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private Frame head = null;

    public void addFrame(Frame frame) {
        if (head == null) {
            head = frame;
            return;
        }
        checkNumberOfFrames();
    }

    private void checkNumberOfFrames() {
        Frame temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.nextFrame;
        }
        if (count > 10) {
            throw new IllegalArgumentException("Invalid match "+count+" frames!");
        }
    }

}
