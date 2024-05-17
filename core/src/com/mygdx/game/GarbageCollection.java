package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.genericClasses.resources.ResourceEnum;
import com.mygdx.genericClasses.resources.ResourceManager;

public class GarbageCollection extends ApplicationAdapter {
	private SpriteBatch batch;
	private ResourceManager resourceManager;
	private Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		resourceManager = new ResourceManager();
		img = resourceManager.getTexture(ResourceEnum.BADLOGIC);
	}

	@Override
	public void render () {
		resourceManager.update();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		resourceManager.dispose();
	}
}
