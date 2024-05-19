package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.genericClasses.resources.ResourceEnum;
import com.mygdx.genericClasses.resources.ResourceManager;

public class GarbageCollection extends ApplicationAdapter {
	private SpriteBatch batch;
	private ResourceManager resourceManager;
	private OrthographicCamera camera;

	static final int WORLD_WIDTH = 100;
	static final int WORLD_HEIGHT = 100;

	private Sprite mapSprite;

	private Texture backGround;
	
	@Override
	public void create () {
		resourceManager = new ResourceManager();

		batch = new SpriteBatch();

		mapSprite = new Sprite(resourceManager.getTexture(ResourceEnum.BADLOGIC));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 1240);

		backGround = new Texture(Gdx.files.internal("sc_map.png"));
	}

	@Override
	public void render () {


		resourceManager.update();
		generalUpdate();
		camera.position.set(mapSprite.getX(), mapSprite.getY(), 0);
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(backGround, 0, 0);
		mapSprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		resourceManager.dispose();
	}

	public void generalUpdate(){
		if(Gdx.input.isKeyPressed(Input.Keys.D) || (Gdx.input.isKeyPressed(Input.Keys.LEFT)))
		{
			mapSprite.setX(mapSprite.getX()+5);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.A) || (Gdx.input.isKeyPressed(Input.Keys.RIGHT)))
		{
			mapSprite.setX(mapSprite.getX()-5);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.S) || (Gdx.input.isKeyPressed(Input.Keys.DOWN)))
		{
			mapSprite.setY(mapSprite.getY()-5);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.W) || (Gdx.input.isKeyPressed(Input.Keys.UP)))
		{
			mapSprite.setY(mapSprite.getY()+5);
		}
	}
}
