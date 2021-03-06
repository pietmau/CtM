package com.bowling.mauriziopietrantuono.bowling.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bowling.mauriziopietrantuono.bowling.R;
import com.bowling.mauriziopietrantuono.bowling.model.BowlingMatch;
import com.bowling.mauriziopietrantuono.bowling.model.Representer;
import com.bowling.mauriziopietrantuono.bowling.model.Scorer;
import com.bowling.mauriziopietrantuono.bowling.presenter.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    private Presenter presenter;
    @BindView(R.id.play) EditText editText;
    @BindView(R.id.score) TextView scoreView;
    @BindView(R.id.representation) TextView representationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // We are ready for dependency injection if we want to implement it
        presenter = new Presenter(new BowlingMatch(), new Scorer(), new Representer());
        presenter.bind(this);
    }

    @OnClick(R.id.go)
    public void onGoClicked() {
        presenter.onGoClicked();
    }

    @Override
    public String getPlay() {
        return editText.getText().toString().trim();
    }

    @Override
    public void setTextEditError(String message) {
        editText.setError(message);
    }

    @Override
    public void setError(String message) {
        Toast.makeText(MainActivity.this, message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setScore(int score) {
        scoreView.setText(Integer.toString(score));
    }

    @Override
    public void setRepresentation(String representation){
        representationView.setText(representation);
    }

    @Override
    public void setInputTextText(String s) {
        editText.setText(s);
    }

    @OnClick(R.id.reset)
    public void onResetClicked(){
        presenter.onResetClicked();
    }
}
