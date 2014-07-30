package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class MiInput extends InputListener{
	Pelotita p;
	MiInput(Pelotita param)
	{
		super();
		p= param;
	}
	
	@Override

	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
	{
		if(!Pausa.pausar)
		{

			MyGdxGame.pelotitas_score++;

			MyGdxGame.Pelotitas_destruidas++; 
			
			if(MyGdxGame.Pelotitas_destruidas %5==0)
			{							
				MyGdxGame.velocidad++; 
				
			}
			MyGdxGame.agregarPelotita();
			
			p.remove();
		}
		return true;
	}
}

