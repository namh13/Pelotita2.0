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
			MyGdxGame.Pelotitas_destruidas++;
			if(MyGdxGame.Pelotitas_destruidas %5==0)
			{							
				MyGdxGame.velocidad++; 
				
			}
			Pelotita p2 = new Pelotita((int)(0),(int)(Math.random()*200%MyGdxGame.h));
			MyGdxGame.s.addActor(p2);
			MyGdxGame.pelotitas.add(p2);
			
			p.remove();
		}
		return true;
	}
}

