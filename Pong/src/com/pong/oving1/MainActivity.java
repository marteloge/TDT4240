package com.pong.oving1;

import sheep.game.Game;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
         
         Game game = new Game(this, null);
         game.pushState(new GameStart());
         setContentView(game);
    }

    
}
