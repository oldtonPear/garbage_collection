package com.mygdx.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class RealtimeMovementStyle extends MovementStyle{
    private Actor player;

    public RealtimeMovementStyle(Actor player){
        this.player = player;
    }

    public Vector2 move() {
        Vector2 finalPosition = new Vector2(0, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            finalPosition.x += 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            finalPosition.x -= 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            finalPosition.y += 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            finalPosition.y -= 2;
        }
        /*player.setX(player.getX() + finalPosition.x);
        player.setY(player.getY() + finalPosition.y);*/
        return finalPosition;
    }
}
