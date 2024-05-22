package com.mygdx.genericClasses;

import com.badlogic.gdx.graphics.Texture;

public class Utils {

    private static final ResourceManager manager = new ResourceManager();

    public static Texture getTexture(ResourceEnum e){
        return manager.getTexture(e);
    }


}
