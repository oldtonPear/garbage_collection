package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.entities.Player;
import com.mygdx.genericClasses.resources.ResourceEnum;
import com.mygdx.genericClasses.resources.ResourceManager;

public class GarbageCollection extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
	private ResourceManager resourceManager;
	private OrthographicCamera camera;

	static final int WORLD_WIDTH = 100;
	static final int WORLD_HEIGHT = 100;

	private Player player;

	private Texture backGround;
	
	@Override
	public void create () {
		resourceManager = new ResourceManager();

		batch = new SpriteBatch();

		player = new Player(resourceManager);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 1240);

		backGround = new Texture(Gdx.files.internal("sc_map.png"));
	}

	@Override
	public void render () {

		resourceManager.update();

		camera.position.set(player.getX(), player.getY(), 0);
		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		batch.draw(backGround, 0, 0);

		player.draw(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		resourceManager.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}
}
