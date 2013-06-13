package mobileapps.agame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.content.Intent;

/**
 * Class to handle help messages
 * @author karin wilding
 */
public class HelpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		
		Intent intent = getIntent();
	    int message = intent.getIntExtra("HELP_SETTINGS", 0);

	    // Create the text view
	    TextView textView = (TextView) findViewById(R.id.help_text);
	    int text = 0;
	    switch (message) {
	    	case 1:
	    		text = R.string.help_text_game;
	    		break;
	    	case 2:
	    		text = R.string.help_text_level;
	    		break;
	    	case 3:
	    		text = R.string.help_text_score;
	    		break;
		}
	    
	    textView.setText(text);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		default:
            return super.onOptionsItemSelected(item);
		}
	}

}
