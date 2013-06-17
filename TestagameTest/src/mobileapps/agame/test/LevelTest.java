package mobileapps.agame.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
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
		 * test if level button gets you to activity with radio buttons
		 * choose radio button one and go to game activity 
		 * check a random card if number are between 0 - 50 */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_level));
		solo.sleep(2000);
		RadioButton rb = (RadioButton) solo.getView(R.id.level_one);
		solo.clickOnView(rb);
		solo.sleep(2000);
		
		Button btn01 = (Button) solo.getCurrentActivity().findViewById(R.id.button01);
		solo.clickOnView(btn01);
		String result = (String) btn01.getText();
		solo.sleep(500);
		assertTrue(Integer.parseInt(result) > 0);
		assertTrue(Integer.parseInt(result) < 19);	

		solo.clickOnActionBarHomeButton();
		
		/** TEST 3:
		 * test if level button gets you to activity with radio buttons, choose radio button two and go to game activity */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_level));
		solo.sleep(2000);
		RadioButton rb2 = (RadioButton) solo.getView(R.id.level_two);
		solo.clickOnView(rb2);
		solo.sleep(2000);
		
		Button btn02 = (Button) solo.getCurrentActivity().findViewById(R.id.button01);
		solo.clickOnView(btn02);
		String result2 = (String) btn02.getText();
		solo.sleep(500);
		assertTrue(Integer.parseInt(result2) > 0);
		assertTrue(Integer.parseInt(result2) < 101);
		
		solo.clickOnActionBarHomeButton();
		
		/** test if level button gets you to activity with radio buttons, choose radio button three and go to game activity */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_level));
		solo.sleep(2000);
		RadioButton rb3 = (RadioButton) solo.getView(R.id.level_three);
		solo.clickOnView(rb3);
		solo.sleep(2000);
		
		Button btn03 = (Button) solo.getCurrentActivity().findViewById(R.id.button01);
		solo.clickOnView(btn03);
		String result3 = (String) btn03.getText();
		solo.sleep(500);
		assertTrue(Integer.parseInt(result3) > 0);
		assertTrue(Integer.parseInt(result3) < 1001);
		
		solo.clickOnActionBarHomeButton();
	

	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
