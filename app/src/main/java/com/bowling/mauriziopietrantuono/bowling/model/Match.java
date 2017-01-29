package com.bowling.mauriziopietrantuono.bowling.model;

import com.bowling.mauriziopietrantuono.bowling.model.frame.Frame;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private Frame head = null;

    public void addFrame(Frame frame) {
        if (head == null) {
            head = frame;
        } else {
            head.nextFrame = frame;
        }
    }

}
