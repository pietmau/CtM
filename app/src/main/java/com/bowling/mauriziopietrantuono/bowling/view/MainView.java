package com.bowling.mauriziopietrantuono.bowling.view;

public interface MainView {
    String getPlay();

    void setTextEditError(String message);

    void setError(String message);

    void setScore(int score);

    void setRepresentation(String representation);

    void setInputTextText(String s);
}
