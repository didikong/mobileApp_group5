package mobileapps.agame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class LevelActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.level, menu);
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
        case R.id.help_settings:
            showHelp();
            return true;
        default:
            return super.onOptionsItemSelected(item);
		}
	}

	/** action bar button 'help' clicked */
	private void showHelp() {
		Intent intent = new Intent(this, HelpActivity.class);
		intent.putExtra("HELP_SETTINGS", 2);
		startActivity(intent);
	}
	
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    Intent intent = null;
		switch(view.getId()) {
	        case R.id.level_one:
	            if (checked)
	            	intent = new Intent (this,PlayActivity.class);

	            	intent.putExtra("Level", 1); 
	            	startActivity(intent);
	            break;
	        case R.id.level_two:
	            if (checked)
	            	intent = new Intent (this,PlayActivity.class);
	            	intent.putExtra("Level", 2); 
	            	startActivity(intent);
	            break;
	        case R.id.level_three:
	            if (checked)
	            	intent = new Intent (this,PlayActivity.class);
	            	intent.putExtra("Level", 3); 
	            	startActivity(intent);
	            break;
	    }
	}


}
