package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class inicio extends InputListener {

	Inicio hola;
	inicio (Inicio p) {
		super ();
		hola = p;
	}
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)	{
		hola.setVisible(false);
		return true;
		
			
		}
}
