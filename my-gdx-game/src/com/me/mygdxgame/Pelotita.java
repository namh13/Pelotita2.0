package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pelotita extends Image{
	public Pelotita(int x, int y) {
		
		super(new Texture("data/pelotita.png"));
		addListener(new MiInput(this));
		this.setX(x);
		this.setY(y);
	}
	
	public void act(float delta)
	{
		
		
		setX(getX()+MyGdxGame.velocidad);
	 	
		if(getX()>420)
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
	
			MyGdxGame.adios.setVisible(true);
			
		}
		
		if(getY()>200)
		{
			setY(0);
		}
		
	}

}
