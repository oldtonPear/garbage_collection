package com.mygdx.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GarbageCollection;
import com.mygdx.genericClasses.resources.ResourceEnum;
import com.mygdx.interfaces.Drawable;

public class Player extends Actor implements Drawable {

    private Sprite sprite;
    public Player(){
        sprite = new Sprite(GarbageCollection.resourceManager.getTexture(ResourceEnum.BADLOGIC));
    }

    public void setX(float x) {
        sprite.setX(x);
    }

    public void setY(float y) {
        sprite.setY(y);
    }
    
    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
    public void update(){

    }
}