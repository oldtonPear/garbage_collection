package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.entities.Player;

public class GarbageCollection extends ApplicationAdapter {
	Stage stage;
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		Player player = new Player();
		player.setMovementStyle(Player.Styles.TILED);
		stage.addActor(player);
		stage.setKeyboardFocus(player);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,0);
		ScreenUtils.clear(1,1,1,0);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	@Override
	public void dispose () {
	}
}
