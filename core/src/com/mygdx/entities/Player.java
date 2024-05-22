package com.mygdx.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.mygdx.genericClasses.resources.ResourceEnum;
import com.mygdx.genericClasses.Utils;
import com.mygdx.movement.MovementStyle;
import com.mygdx.movement.RealtimeMovementStyle;
import com.mygdx.movement.TiledMovementStyle;

public class Player extends Actor {

    private Sprite sprite;
    private MovementStyle movementStyle;
    public enum Styles {REALTIME, TILED}

    public Player(int x, int y){
        sprite = new Sprite(Utils.getTexture(ResourceEnum.PLAYER));
        setX(x);
        setY(y);
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setTouchable(Touchable.enabled);
    }

    public void setMovementStyle(Styles s) {
        switch (s){
            case REALTIME :
                movementStyle = new RealtimeMovementStyle(this);
                break;
            case TILED :
                movementStyle = new TiledMovementStyle(this);
                break;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        Vector2 movement = movementStyle.move();

        if(movementStyle instanceof TiledMovementStyle){
            MoveByAction mba = new MoveByAction();
            mba.setAmount(movement.x, movement.y);
            mba.setDuration(0.1f);
            this.addAction(mba);
        }
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
        sprite.setPosition(getX(), getY());
    }
}