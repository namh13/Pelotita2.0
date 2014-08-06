package com.me.mygdxgame;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

class Imagen extends Sprite
{
	Imagen(Texture texture)
	{
		super(texture);
	}
	InputListener l;
	void avanzar()
	{
		setX(getX()+0.01f);
		if(getX()>0.5f)
			setX(-0.5f);
	}
	
}

public class MyGdxGame implements ApplicationListener {
	public static int Pelotitas_destruidas;
	public static int pelotitas_score =0; 
	public static float velocidad; 
	private Texture texture;
	public static Image i;
	int frame=0;
	public static Stage s;
	public static ArrayList<Image>pelotitas=new ArrayList<Image>();
	public static ArrayList<PelotitaMala>pelotitasm=new ArrayList<PelotitaMala>();
	public static Inicio hola; 
	public static float w, h; 
	int rotacion=0;
	private BitmapFont font;
	private Skin uiSkin;
	private LabelStyle label_syle;
	public static Label score_label;
	public static Label top_score_label;
	private String score;
	public static Fin adios;
	public static int top_score=0;
	static Preferences prefs;

	static void agregarPelotita()
	{
		int x = (int) (Math.random()*1000); 
		if(x%10 !=0){
			Pelotita p2 = new Pelotita((int)(0),(int)(Math.random()*200%MyGdxGame.h));
			p2.setX(-p2.getWidth());
			MyGdxGame.s.addActor(p2);
			p2.toBack();
			MyGdxGame.i.toBack();
			MyGdxGame.pelotitas.add(p2);
		}
		else
		{
			PelotitaEspecial p3 = new PelotitaEspecial((int)(0),(int)(Math.random()*200%MyGdxGame.h));
			p3.setX(-p3.getWidth());
			MyGdxGame.s.addActor(p3);
			p3.toBack();
			MyGdxGame.i.toBack();
			MyGdxGame.pelotitas.add(p3);
		}
	}
	static void limpiar()
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
	}
	
	public static void inicializar()
	{
		Pelotitas_destruidas=0;
		pelotitas_score=0; 
		velocidad=1;
		limpiar();
		
		for(int i=0; i<=3; i++)
		{
			
			Pelotita p = new Pelotita((int)(Math.random()*410%w)-400,(int)(Math.random()*180%h));
			s.addActor(p);
			pelotitas.add(p);
		}
		
		for(int e=0; e<5; e++)
		{
			PelotitaMala t = new PelotitaMala((int)(Math.random()*1000%w),(int)(Math.random()*1000%h),adios);
			s.addActor(t);
			pelotitasm.add(t);
		}
		
		adios.setVisible(false);
		hola.setVisible(true);
		hola.toFront();
		adios.toFront();
		score_label.toFront();
		top_score_label.toFront();
	}
	
	@Override
	public void create()
	{		
		 w = Gdx.graphics.getWidth();
		 h = Gdx.graphics.getHeight();
		
		texture = new Texture(Gdx.files.internal("data/fondo1.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		
		s=new Stage();
		i=new Image(texture);
		s.addActor(i);
		
		Pelotitas_destruidas = 0; 
		
		
		Gdx.input.setInputProcessor(s);
		
		Pausa pausar = new Pausa();
		s.addActor(pausar);
		
		adios = new Fin();
		hola = new Inicio();
		
		font = new BitmapFont(Gdx.files.internal("data/font/Fugaz.fnt"),false);
		uiSkin = new Skin();
		uiSkin.add("default", new BitmapFont());
		//Label style
		label_syle = new LabelStyle();
		label_syle.font = font;
		label_syle.fontColor = Color.WHITE;
		uiSkin.add("default", label_syle);
		score_label = new Label("Puntos: "+score,uiSkin);
		score_label.setColor(Color.BLACK);
		
		top_score_label = new Label("Top: "+top_score,uiSkin);
		top_score_label.setX(100);
		top_score_label.setColor(Color.BLACK);
		
		s.addActor(adios);
		s.addActor(hola);
		s.addActor(score_label);
		s.addActor(top_score_label);
		
		initPrefs();
		top_score=getTopScore();
		
		inicializar();	
	}
	

	@Override
	public void dispose() {
		texture.dispose();
	}

	@Override
	public void render() {	
		
		//imagen.avanzar();
//		s.setViewport(100, 50, true);
		score_label.setText(""+pelotitas_score);
		top_score_label.setText(""+top_score);
		
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if(!Pausa.pausar &&!hola.isVisible())
		{
			s.act();
		}
		s.draw();
//		s.setViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
	}

	@Override
	public void resize(int width, int height) {
//		s.setViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		s.setViewport(480, 320, true);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	void initPrefs()
	{
		prefs = Gdx.app.getPreferences("scores");
	}
	
	public static void setScore(int score)
	{
		prefs.putInteger("top_score", score);
		prefs.flush();
	}

	static int getTopScore()
	{
//		return 0;
		return prefs.getInteger("top_score");
	}
}
