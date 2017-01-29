package com.bowling.mauriziopietrantuono.bowling.view;

import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.bowling.mauriziopietrantuono.bowling.R;
import com.bowling.mauriziopietrantuono.bowling.presenter.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    Presenter presenter;
    @BindView(R.id.play) EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter= new Presenter();
        presenter.bind(this);
    }

    @OnClick(R.id.go)
    public void onGoClicked(){
        presenter.onGoClicked();
    }

    @Override
    public String getPlay(){
        return editText.getText().toString();
    }
}
