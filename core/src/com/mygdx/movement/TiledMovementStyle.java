package com.mygdx.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TiledMovementStyle extends MovementStyle{

    private long lastMove;
    private Actor player;

    public TiledMovementStyle(Actor player){
        lastMove = System.currentTimeMillis();
        this.player = player;
    }

    public Vector2 move() {
        System.out.println((System.currentTimeMillis() - lastMove));
        if((System.currentTimeMillis() - lastMove) < 50) return new Vector2(0,0);
        lastMove = System.currentTimeMillis();
        Vector2 finalPosition = new Vector2(0, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            finalPosition.x += 50;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            finalPosition.x -= 50;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            finalPosition.y += 50;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            finalPosition.y -= 50;
        }
        return finalPosition;
    }
}
