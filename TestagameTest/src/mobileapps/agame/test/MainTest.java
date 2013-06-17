package mobileapps.agame.test;

import com.jayway.android.robotium.solo.Solo;

import mobileapps.agame.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
import mobileapps.agame.R;

//public class MainTest extends TestCase {
public class MainTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	
	public MainTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testButtons() {	
		/** TEST 1:
		 * assert MainActity */
		solo.assertCurrentActivity(getName(), MainActivity.class);
		
		
		/** TEST 2:
		 * basic test if "start game" button exists */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_game));
		solo.sleep(2000);
		solo.getText("");
		
		/** basic test if home button in game-actionbar exists */
		solo.clickOnActionBarHomeButton();
		
		
		/** TEST 3:
		 * basic test if "level" button exists */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_level));
		solo.sleep(2000);
		
		/** basic test if home button in level-actionbar exists */
		solo.clickOnActionBarHomeButton();
		
		
		/** TEST 4:
		 * basic test if "highscore" button exists */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_highscore));
		solo.sleep(2000);
		
		/** basic test if home button in highscore-actionbar exists */
		solo.clickOnActionBarHomeButton();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
