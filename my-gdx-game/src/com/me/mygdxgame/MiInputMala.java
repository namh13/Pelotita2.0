package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class MiInputMala extends InputListener{
	PelotitaMala t;
	Fin adios;
	MiInputMala(PelotitaMala param ,Fin p)
	{
		super();
		t = param;
		adios = p;
	}
	
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
	{
		if(!Pausa.pausar)
		{
			for(int i=0; i<MyGdxGame.pelotitas.size();i++)
			{
				MyGdxGame.pelotitas.get(i).remove(); 
				
			}
			MyGdxGame.pelotitas.clear();
			
			for(int i=0; i<MyGdxGame.pelotitasm.size();i++)
			{
				MyGdxGame.pelotitasm.get(i).remove(); 
			}
			MyGdxGame.pelotitasm.clear();
	
			adios.setVisible(true);
		}
		return true;
	}

}
