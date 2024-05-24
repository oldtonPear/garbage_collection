package com.mygdx.movement;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.entities.Player;
import com.mygdx.genericClasses.Utils;
import com.mygdx.genericClasses.resources.ResourceEnum;

public class PlayerAnimationManager {

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

        int FRAME_COLS = 4;
        int FRAME_ROWS = 3;

        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
				walkSheet.getWidth() / FRAME_COLS,
				walkSheet.getHeight() / FRAME_ROWS);

        TextureRegion[] walkDownFrames = new TextureRegion[FRAME_ROWS];
        TextureRegion[] walkUpFrames = new TextureRegion[FRAME_ROWS];
        TextureRegion[] walkLeftFrames = new TextureRegion[FRAME_ROWS];
        TextureRegion[] walkRightFrames = new TextureRegion[FRAME_ROWS];

		for (int i = 0; i < FRAME_ROWS; i++) {
			walkDownFrames[i] = tmp[i][0];
            walkUpFrames[i] = tmp[i][1];
            walkLeftFrames[i] = tmp[i][2];
            walkRightFrames[i] = tmp[i][3];

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

    /**
     * 
     * @param delta <br>
     * direction 0:down, 1:up, 2:left, 3:right
     */
    public void updateAnimation(float delta){
        stateTime += delta;
        currentFrame = currentAnimation.getKeyFrame(stateTime, true);
    }

    public void setCurrentAnimation(int direction){
        switch (direction) {
            case 0 -> currentAnimation = walkDownAnimation;
            case 1 -> currentAnimation = walkUpAnimation;
            case 2 -> currentAnimation = walkLeftAnimation;
            case 3 -> currentAnimation = walkRightAnimation;
        }
    }
}
