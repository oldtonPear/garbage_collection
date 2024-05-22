package com.mygdx.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

import java.util.ArrayList;

public class TiledMovementStyle extends MovementStyle{

    private ArrayList<Character> inputs;
    private long lastMove;
    private Actor player;

    public TiledMovementStyle(Actor player){
        inputs = new ArrayList<>();
        lastMove = 0;
        this.player = player;
    }

    public void move() {
        if ((Gdx.graphics.getFrameId() - lastMove) < 9) return;
        if ((Gdx.graphics.getFrameId() - lastMove) <= 12) {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) inputs.add('W');
            if (Gdx.input.isKeyPressed(Input.Keys.A)) inputs.add('A');
            if (Gdx.input.isKeyPressed(Input.Keys.S)) inputs.add('S');
            if (Gdx.input.isKeyPressed(Input.Keys.D)) inputs.add('D');
            return;
        }

        float x = 0, y = 0;

        if (inputs.size() >= 1) lastMove = Gdx.graphics.getFrameId();
        for (Character c: inputs) {
            switch (c){
                case 'W' -> y += 50;
                case 'A' -> x -= 50;
                case 'S' -> y -= 50;
                case 'D' -> x += 50;
            }
        }

        MoveByAction mba = new MoveByAction();
        mba.setAmount(x, y);
        mba.setDuration(0.1f);
        player.addAction(mba);
    }
}
