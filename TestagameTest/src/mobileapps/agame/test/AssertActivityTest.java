package mobileapps.agame.test;

import com.jayway.android.robotium.solo.Solo;

import mobileapps.agame.HelpActivity;
import mobileapps.agame.HighscoreActivity;
import mobileapps.agame.LevelActivity;
import mobileapps.agame.MainActivity;
import mobileapps.agame.PlayActivity;
import mobileapps.agame.R;
import android.test.ActivityInstrumentationTestCase2;


public class AssertActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	
	public AssertActivityTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testButtons() {
		/** assert HelpActivity */		
		solo.assertCurrentActivity(getName(), HelpActivity.class);

		/** assert HighscoreActivity */
		solo.assertCurrentActivity(getName(), HighscoreActivity.class);
		
		/** assert LevelActivity */
		solo.assertCurrentActivity(getName(), LevelActivity.class);
		
		/** assert MainActity */
		solo.assertCurrentActivity(getName(), MainActivity.class);
		
		/** assert PlayActivity */
		solo.assertCurrentActivity(getName(), PlayActivity.class);

	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}