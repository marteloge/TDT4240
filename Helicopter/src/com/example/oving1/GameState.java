package com.example.oving1;

import sheep.game.State;
import sheep.graphics.Font;
import android.content.res.Resources;
import android.graphics.*;
import android.view.MotionEvent;
import sheep.input.TouchListener;


public class GameState extends State implements TouchListener{
	
	private Helicopter helicopter;
	private Helicopter h2;
	private Helicopter h3;
	private int canvasHeight, canvasWidth;
	
	
		
	@Override
	public boolean onTouchMove(MotionEvent event) {
		helicopter.setPosition(event.getX(), event.getY());
		return true;
	}

	//istedet for å dra og klikke, så kan den bare klikke
	@Override
	public boolean onTouchUp(MotionEvent event) {
		helicopter.setPosition(event.getX(), event.getY());
//		helicopter.setSpeed((event.getX() - helicopter.getX())*10,
//				event.getY() - helicopter.getY())*10 );
		return true;
	}

	public GameState(Resources resources){
		helicopter = new Helicopter(BitmapFactory.decodeResource(resources, R.drawable.helisprite), 
				0, 0, 	//x, y
				100,		//fps 
				4		//frameCount
				);
		helicopter.setSpeed(1000, 1000);
		helicopter.update(System.currentTimeMillis());
		
		h2 = new Helicopter(BitmapFactory.decodeResource(resources, R.drawable.helisprite),
				200, 100, 	//x, y
				100,		//fps 
				4		//frameCount
				);
		h2.setSpeed(1000,-1000);
		h2.update(System.currentTimeMillis());
		
		h3 = new Helicopter(BitmapFactory.decodeResource(resources, R.drawable.helisprite),
				100, 400, 	//x, y
				100,		//fps 
				4		//frameCount
				);
		
		h3.setSpeed(1000,1000);
		h3.update(System.currentTimeMillis());
	}
	

	

	@Override
	public void draw(Canvas canvas) {
		canvasHeight = canvas.getHeight();
		canvasWidth = canvas.getWidth();
		canvas.drawColor(Color.BLACK);
		helicopter.draw(canvas);
		h2.draw(canvas);
		h3.draw(canvas);
		Font font = new Font(0, 55, 20, 30, Typeface.SERIF, Typeface.NORMAL);
		canvas.drawText("Helikopter er på x: " + helicopter.getX() + 
				" y: " + helicopter.getY() , 30, 30, font);
	}

	@Override
	public void update(float dt) {
		helicopter.update(System.currentTimeMillis());
		h2.update(System.currentTimeMillis());
		h3.update(System.currentTimeMillis());
		
		if(helicopter.getX()>(canvasWidth-helicopter.getHelicopterWidth()) || helicopter.getX()<0)
		{
			helicopter.setSpeed(-helicopter.getSpeed().getX(), helicopter.getSpeed().getY());
			helicopter.flipHelicopter();
		}
		if(helicopter.getY()>(canvasHeight-helicopter.getHelicopterHeight()) || helicopter.getY()<0)
		{
			helicopter.setSpeed(helicopter.getSpeed().getX(), -helicopter.getSpeed().getY());
		}
		
		if(h2.getX()>(canvasWidth-h2.getHelicopterWidth()) || h2.getX()<0)
		{
			h2.setSpeed(-h2.getSpeed().getX(), h2.getSpeed().getY());
			h2.flipHelicopter();
		}
		if(h2.getY()>(canvasHeight-h2.getHelicopterHeight()) || h2.getY()<0)
		{
			h2.setSpeed(h2.getSpeed().getX(), -h2.getSpeed().getY());
		}
		
		if(h3.getX()>(canvasWidth-h3.getHelicopterWidth()) || h3.getX()<0)
		{
			h3.setSpeed(-h3.getSpeed().getX(), h3.getSpeed().getY());
			h3.flipHelicopter();
		}
		if(h3.getY()>(canvasHeight-h3.getHelicopterHeight()) || h3.getY()<0)
		{
			h3.setSpeed(h3.getSpeed().getX(), -h3.getSpeed().getY());
		}
		
		
		
		if(helicopter.getSpriteRect().intersect(h2.getSpriteRect()) ||
				h2.getSpriteRect().intersect(helicopter.getSpriteRect())){
			helicopter.setSpeed(-helicopter.getSpeed().getX(), -helicopter.getSpeed().getY());
			helicopter.flipHelicopter();
			h2.setSpeed(-h2.getSpeed().getX(), -h2.getSpeed().getY());
			h2.flipHelicopter();
		}
		
		
		if(helicopter.getSpriteRect().intersect(h3.getSpriteRect()) ||
				h3.getSpriteRect().intersect(helicopter.getSpriteRect())){
			helicopter.setSpeed(-helicopter.getSpeed().getX(), -helicopter.getSpeed().getY());
			helicopter.flipHelicopter();
			h3.setSpeed(-h3.getSpeed().getX(), -h3.getSpeed().getY());
			h3.flipHelicopter();
		}
		
		if(h3.getSpriteRect().intersect(h2.getSpriteRect()) ||
				h2.getSpriteRect().intersect(h3.getSpriteRect())){
			h2.setSpeed(-h2.getSpeed().getX(), -h2.getSpeed().getY());
			h2.flipHelicopter();
			h3.setSpeed(-h3.getSpeed().getX(), -h3.getSpeed().getY());
			h3.flipHelicopter();
		}
	}
	
}