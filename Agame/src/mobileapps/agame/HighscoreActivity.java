package mobileapps.agame;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;

/**
 * Class to handle high score activity
 * @author karin wilding
 */
public class HighscoreActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		
		/* normal onCreate behavior */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
              
        /* add action bar and navigation tab mode */
        final ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /* add three tabs for level 1, 2, 3 high score lists */
        bar.addTab(bar.newTab()
                .setText(R.string.level_one)
                .setTabListener(new TabListener<LevelOneFragment>(
                        this, "", LevelOneFragment.class)));
        
        bar.addTab(bar.newTab()
                .setText(R.string.level_two)
                .setTabListener(new TabListener<LevelTwoFragment>(
                        this, "", LevelTwoFragment.class)));
        
        bar.addTab(bar.newTab()
                .setText(R.string.level_three)
                .setTabListener(new TabListener<LevelThreeFragment>(
                        this, "", LevelThreeFragment.class)));
               
        /* home/ up button */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
	
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.highscore, menu);
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
		case R.id.delete_scores:
			HighscoreHandler.getInstance().deleteScores(this.getActionBar().getSelectedTab().getPosition());
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
		intent.putExtra("HELP_SETTINGS", 3);
		startActivity(intent);
	}
}

