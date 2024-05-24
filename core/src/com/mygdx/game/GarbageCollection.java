package com.mygdx.game;

import com.badlogic.gdx.*;
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
