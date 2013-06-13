package mobileapps.agame;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;


public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** menu button 'start game' onClick */
	public void newGame(View view) {
		Intent intent = new Intent(this, PlayActivity.class);
		startActivity(intent);
	}
	
	/** menu button 'high score' onClick*/
	public void showHighscore(View view) {
		Intent intent = new Intent(this, HighscoreActivity.class);
		startActivity(intent);
	}
	
	/** menu button 'levels' onClick */
	public void changeLevel(View view) {
		Intent intent = new Intent(this, LevelActivity.class);
		startActivity(intent);
	}
	
}

