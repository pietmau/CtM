package com.bowling.mauriziopietrantuono.bowling.model;

class Bonus {

    final Ball ball;

    public Bonus(int score) {
        this.ball = new Ball(score);
    }

}
