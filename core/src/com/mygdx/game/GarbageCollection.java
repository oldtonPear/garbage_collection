package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.entities.Player;
import com.mygdx.genericClasses.resources.ResourceEnum;
import com.mygdx.genericClasses.Utils;
import com.mygdx.screens.MainScreen;

public class GarbageCollection extends Game {

	
	@Override
	public void create () {
		setScreen(new MainScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
