package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Fin extends Image
{
	public Fin()
	{
		 super(new Texture("data/bye.png"));
		 addListener(new ClickListener(){
				@Override
				public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
				{
					MyGdxGame.inicializar();
					return true;
				}
		 });
	}
}
