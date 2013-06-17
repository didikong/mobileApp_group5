package mobileapps.agame.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.RadioButton;

import com.jayway.android.robotium.solo.Solo;

import mobileapps.agame.LevelActivity;
import mobileapps.agame.R;

public class LevelTest  extends ActivityInstrumentationTestCase2<LevelActivity> {

	private Solo solo;
	
	public LevelTest() {
		super(LevelActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testButtons() {	
		/** TEST 1:
		 * assert LevelActivity */
		solo.assertCurrentActivity(getName(), LevelActivity.class);
		
		
		/** TEST 2:
		 * test if level button gets you to activity with radio buttons, choose radio button one and go to game activity */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_level));
		solo.sleep(2000);
		RadioButton rb = (RadioButton) solo.getView(R.id.level_one);
		solo.clickOnView(rb);
		solo.sleep(2000);
		solo.clickOnActionBarHomeButton();
		
		/** test if level button gets you to activity with radio buttons, choose radio button two and go to game activity */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_level));
		solo.sleep(2000);
		RadioButton rb2 = (RadioButton) solo.getView(R.id.level_two);
		solo.clickOnView(rb2);
		solo.sleep(2000);
		solo.clickOnActionBarHomeButton();
		
		/** test if level button gets you to activity with radio buttons, choose radio button three and go to game activity */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_level));
		solo.sleep(2000);
		RadioButton rb3 = (RadioButton) solo.getView(R.id.level_three);
		solo.clickOnView(rb3);
		solo.sleep(2000);
		solo.clickOnActionBarHomeButton();
	

	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
