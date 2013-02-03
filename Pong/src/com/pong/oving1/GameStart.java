package com.pong.oving1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.view.MotionEvent;
import sheep.game.State;
import sheep.graphics.Font;
import sheep.input.TouchListener;

public class GameStart extends State implements TouchListener{
	
	private Font font;
	
	public GameStart(){
		font = new Font(100, 100, 100, 60, Typeface.SANS_SERIF, Typeface.BOLD);
		font.setTextAlign(Align.CENTER);
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		canvas.drawText("Tap to start", canvas.getWidth()/2, 200, font);
		
	}

	@Override
	public boolean onTouchUp(MotionEvent event) {
		
		getGame().popState();
		getGame().pushState(new GameState());
		return false;
	}
	
	
	
	
	
}
