package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.entities.Player;
import com.mygdx.genericClasses.resources.ResourceEnum;
import com.mygdx.genericClasses.Utils;

public class GarbageCollection extends ApplicationAdapter {
	Stage stage;
	Texture backGround;
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		backGround = Utils.getTexture(ResourceEnum.BACKGROUND);

		Player player = new Player(640/2, 480/2);
		player.setMovementStyle(Player.Styles.TILED);
		stage.addActor(player);
		stage.setKeyboardFocus(player);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,0);
		ScreenUtils.clear(1,1,1,0);

		stage.getBatch().begin();
		stage.getBatch().draw(backGround, 0, 0, 640, 480);
		stage.getBatch().end();

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}
}
