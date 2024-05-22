package com.mygdx.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

public class TiledMovementStyle extends MovementStyle{

    private long lastMove;
    private Actor player;

    public TiledMovementStyle(Actor player){
        lastMove = 0;
        this.player = player;
    }

    public void move() {
        if((System.currentTimeMillis() - lastMove) < 150) return;
        float x = 0, y = 0;
        boolean moved = false;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            moved = true;
            x += 50;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            moved = true;
            x -= 50;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            moved = true;
            y += 50;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            moved = true;
            y -= 50;
        }
        if (moved) lastMove = System.currentTimeMillis();
        MoveByAction mba = new MoveByAction();
        mba.setAmount(x, y);
        mba.setDuration(0.1f);
        player.addAction(mba);
    }
}
