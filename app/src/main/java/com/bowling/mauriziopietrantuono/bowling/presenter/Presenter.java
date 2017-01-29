package com.bowling.mauriziopietrantuono.bowling.presenter;


import com.bowling.mauriziopietrantuono.bowling.model.BowlingMatch;
import com.bowling.mauriziopietrantuono.bowling.model.InvalidPlayException;
import com.bowling.mauriziopietrantuono.bowling.model.Scorer;
import com.bowling.mauriziopietrantuono.bowling.view.MainView;

public class Presenter {
    private MainView view;
    private final BowlingMatch bowlingMatch;
    private final Scorer scorer;

    public Presenter(BowlingMatch bowlingMatch, Scorer scorer) {
        this.bowlingMatch = bowlingMatch;
        this.scorer = scorer;
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
            updateView();
        } catch (InvalidPlayException e) {
            view.setError(e.getMessage());
        }
    }

    private void updateView() {
        view.setScore(scorer.score(bowlingMatch));
    }
}
