package com.bowling.mauriziopietrantuono.bowling.presenter;


import com.bowling.mauriziopietrantuono.bowling.model.BowlingMatch;
import com.bowling.mauriziopietrantuono.bowling.model.InvalidPlayException;
import com.bowling.mauriziopietrantuono.bowling.view.MainView;

public class Presenter {
    private MainView view;
    private BowlingMatch bowlingMatch;

    public Presenter(BowlingMatch bowlingMatch) {
        this.bowlingMatch = bowlingMatch;
    }

    public void bind(MainView view) {
        this.view = view;
    }

    public void onGoClicked() {
        view.setTextEditError(null);
        try {
            int currentPlay = Integer.parseInt(view.getPlay());
            updateGame(currentPlay);
        } catch (NumberFormatException e) {
            view.setTextEditError(e.getMessage());
        }
    }

    private void updateGame(int currentPlay) {
        try {
            bowlingMatch.playBall(currentPlay);
        } catch (InvalidPlayException e) {
            view.setError(e.getMessage());
        }

    }
}
