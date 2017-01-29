package com.bowling.mauriziopietrantuono.bowling.model;

public class InvalidPlayException extends Exception {

    public InvalidPlayException(int size) {
        super("Invalid number of plays " + size);
    }

    public InvalidPlayException(String message) {
        super(message);
    }
}
