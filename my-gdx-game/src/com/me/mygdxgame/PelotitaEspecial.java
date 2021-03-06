package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PelotitaEspecial extends Image{
	public PelotitaEspecial(int x, int y)
	{
		super(new Texture("data/PelotitaEspecial.png"));
		final PelotitaEspecial p = this; 
		addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				if(!Pausa.pausar)
				{

					MyGdxGame.pelotitas_score+=5;
					
					if(MyGdxGame.pelotitas_score>MyGdxGame.top_score)
					{
						MyGdxGame.top_score=MyGdxGame.pelotitas_score;
						MyGdxGame.setScore(MyGdxGame.top_score);
					}

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
		});
		this.setX(x);
		this.setY(y);
	}
	
	public void act(float delta)
	{
		setX(getX()+MyGdxGame.velocidad);
	 	
		if(getX()>420+this.getWidth())
		{
			MyGdxGame.agregarPelotita();
			
			this.remove();
		}
		
		if(getY()>200)
		{
			setY(0);
		}
	}
}
