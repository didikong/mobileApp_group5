package mobileapps.agame.test;

import mobileapps.agame.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.RadioButton;

import com.jayway.android.robotium.solo.Solo;

import mobileapps.agame.HelpActivity;
import mobileapps.agame.R;

public class HelpTest  extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	
	public HelpTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testButtons() {	
		/** test help menu exists in PlayActivity */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_game));
		solo.sendKey(Solo.MENU);
		solo.clickOnText(getActivity().getResources().getString(R.string.help_settings));
		solo.sleep(2000);
		solo.goBack();
		solo.clickOnActionBarHomeButton();
		
		/** test help menu exists in PlayActivity */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_level));
		solo.sendKey(Solo.MENU);
		solo.clickOnText(getActivity().getResources().getString(R.string.help_settings));
		solo.sleep(2000);
		solo.goBack();
		solo.clickOnActionBarHomeButton();
		
		/** test help menu exists in PlayActivity */
		solo.clickOnText(getActivity().getResources().getString(R.string.button_highscore));
		solo.sendKey(Solo.MENU);
		solo.clickOnText(getActivity().getResources().getString(R.string.help_settings));
		solo.sleep(2000);
		solo.goBack();
		solo.clickOnActionBarHomeButton();
		
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
