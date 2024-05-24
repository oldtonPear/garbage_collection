package com.mygdx.movement;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.entities.Player;
import com.mygdx.genericClasses.Utils;
import com.mygdx.genericClasses.resources.ResourceEnum;

public class PlayerAnimationManager {

    private final int FRAME_COLS = 4, FRAME_ROWS = 3;

    Animation<TextureRegion> walkDownAnimation;
    Animation<TextureRegion> walkUpAnimation;
    Animation<TextureRegion> walkLeftAnimation;
    Animation<TextureRegion> walkRightAnimation;

    private Texture walkSheet;
    Animation<TextureRegion> currentAnimation;
    
    TextureRegion currentFrame;

    float stateTime;

    public PlayerAnimationManager(Player p){
        walkSheet = Utils.getTexture(ResourceEnum.PLAYER);

        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
				walkSheet.getWidth() / FRAME_COLS,
				walkSheet.getHeight() / FRAME_ROWS);

        int index;

        TextureRegion[] walkDownFrames = new TextureRegion[FRAME_ROWS];
		index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			walkDownFrames[index++] = tmp[i][0];
		}

        TextureRegion[] walkUpFrames = new TextureRegion[FRAME_ROWS];
		index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			walkUpFrames[index++] = tmp[i][1];
		}

        TextureRegion[] walkLeftFrames = new TextureRegion[FRAME_ROWS];
		index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			walkLeftFrames[index++] = tmp[i][2];
		}

        TextureRegion[] walkRightFrames = new TextureRegion[1 * FRAME_ROWS];
		index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
            walkRightFrames[index++] = tmp[i][3];
		}

        walkDownAnimation = new Animation<TextureRegion>(0.2f, walkDownFrames);
        walkUpAnimation = new Animation<TextureRegion>(0.2f, walkUpFrames);
        walkLeftAnimation = new Animation<TextureRegion>(0.2f, walkLeftFrames);
        walkRightAnimation = new Animation<TextureRegion>(0.2f, walkRightFrames);

        currentAnimation = walkDownAnimation;

		stateTime = 0f;
    }

    public TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(float stateTime) {
        currentFrame = walkDownAnimation.getKeyFrame(stateTime, true);
    }

    /**
     * 
     * @param delta
     * @param direction 0:down, 1:up, 2:left, 3:right
     */
    public void updateAnimation(float delta){
        stateTime += delta;
        currentFrame = currentAnimation.getKeyFrame(stateTime, true);
    }

    public void setCurrentAnimation(int direction){
        switch (direction) {
            case 0 -> {currentAnimation = walkDownAnimation;}
            case 1 -> {currentAnimation = walkUpAnimation;}
            case 2 -> {currentAnimation = walkLeftAnimation;}
            case 3 -> {currentAnimation = walkRightAnimation;}
        }
    }
}
