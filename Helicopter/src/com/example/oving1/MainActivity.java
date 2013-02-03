package com.example.oving1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import sheep.game.*;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Game game = new Game(this, null);
        game.pushState(new GameState(game.getResources()));
        setContentView(game);
        
    }
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
