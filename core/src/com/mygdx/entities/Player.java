package com.mygdx.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.mygdx.genericClasses.resources.ResourceEnum;
import com.mygdx.genericClasses.Utils;
import com.mygdx.movement.MovementStyle;
import com.mygdx.movement.PlayerAnimationManager;
import com.mygdx.movement.RealtimeMovementStyle;
import com.mygdx.movement.TiledMovementStyle;

public class Player extends Actor {

    PlayerAnimationManager playerAnimationManager;
    
    private MovementStyle movementStyle;
    public enum Styles {REALTIME, TILED}

    public Player(int x, int y){

        setX(x);
        setY(y);

        playerAnimationManager = new PlayerAnimationManager(this);

        setBounds(getX(), getY(), getWidth(), getHeight());
        setTouchable(Touchable.enabled);
    }

    public void setMovementStyle(Styles s) {
        switch (s){
            case REALTIME :
                movementStyle = new RealtimeMovementStyle(this, playerAnimationManager);
                break;
            case TILED :
                movementStyle = new TiledMovementStyle(this);
                break;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(playerAnimationManager.getCurrentFrame(), getX(), getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    
        playerAnimationManager.updateAnimation(delta);
        playerAnimationManager.setCurrentAnimation(movementStyle.move());
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
    }
}