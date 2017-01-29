package com.bowling.mauriziopietrantuono.bowling.model;

public class Bonus {

    Ball ball;

    public Bonus(int score) {
        this.ball = new Ball(score);
    }

    public int getScore(){
        return ball.getScore();
    }
}
