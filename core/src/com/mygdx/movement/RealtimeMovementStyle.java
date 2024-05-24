package com.mygdx.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class RealtimeMovementStyle extends MovementStyle{
    private final Actor player;

    public RealtimeMovementStyle(Actor player, PlayerAnimationManager playerAnimationManager){
        this.player = player;
    }

    public int move() {
        int direction = -1;
        Vector2 finalPosition = new Vector2(0, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            finalPosition.x += 2;
            if(!Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.S)){
                direction = 3;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            finalPosition.x -= 2;
            if(!Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.S)){
                direction = 2;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            direction = 1;
            finalPosition.y += 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            finalPosition.y -= 2;
            direction = 0;
        }

        player.setX(player.getX() + finalPosition.x);

        player.setY(player.getY() + finalPosition.y);
        player.getStage().getCamera().translate(finalPosition.x, finalPosition.y, 0);
        return direction;
    }
}
