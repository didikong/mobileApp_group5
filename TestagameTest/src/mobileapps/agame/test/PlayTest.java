package mobileapps.agame.test;

import com.jayway.android.robotium.solo.Solo;

import mobileapps.agame.HighscoreHandler;
import mobileapps.agame.PlayActivity;
import mobileapps.agame.R;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;

public class PlayTest extends ActivityInstrumentationTestCase2<PlayActivity> {

	private PlayActivity act;
	
	public PlayTest() {
		super(PlayActivity.class);
	}

	private Solo solo;
	
	
	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	/*
	 * after the play Activity is started this test tests if the map is initialized right
	 */
	public void testInit() {
		/** TEST 1:
		 * assert PlayActivity */
		solo.assertCurrentActivity(getName(), PlayActivity.class);
		
		
		act = getActivity();
		String[] calc = act.getCalc();
		String[] result = act.getResult();
		int[] map = act.getMap();
		/** TEST 2:
		 * member variable not null
		 */
		assertNotNull(calc);
		assertNotNull(result);
		assertNotNull(map);
		
		/** TEST3:
		 * map is right
		 */
		int size = map.length;
		for(int i = 0; i < size; i++) {
			String[] split = calc[map[i]].split(" ");
			int value1 = Integer.parseInt(split[0]);
			int value2 = Integer.parseInt(split[2]);
			int value3 = Integer.parseInt(result[i]);
			assertTrue(value1 + value2 == value3);
		}
		
		solo.clickOnActionBarHomeButton();
	}
	

	/*
	 * This test click on two buttons. If the there are the same, they should be shown
	 * all the time, if not they should be hide after 2,5sec
	 */
	public void testHide() {
		// at the start the buttons have no text
		assertEquals("", getActivity().getResources().getString(R.string.button00));
		assertEquals("", getActivity().getResources().getString(R.string.button01));
		solo.sleep(500);
		
		//click the first button
		Button btn00 = (Button) solo.getCurrentActivity().findViewById(R.id.button00);
		solo.clickOnView(btn00);
		String calc = (String) btn00.getText();
		solo.sleep(500);
		assertTrue(calc.length() > 0);
			
		//click the second button
		Button btn01 = (Button) solo.getCurrentActivity().findViewById(R.id.button01);
		solo.clickOnView(btn01);
		String result = (String) btn01.getText();
		solo.sleep(500);
		assertTrue(result.length() > 0);
		
		solo.sleep(3500);
		
		//check if there are the same
		String[] splitResult = calc.split(" ");
		int value1 = Integer.parseInt(splitResult[0]);
		int value2 = Integer.parseInt(splitResult[2]);
		
		//Text didn't hide
		if(value1 + value2 == Integer.parseInt(result)) {
			assertTrue(calc.length() > 0);
			assertTrue(result.length() > 0);
		}
		//Text is hidden
		else {
			assertEquals("", getActivity().getResources().getString(R.string.button00));
			assertEquals("", getActivity().getResources().getString(R.string.button01));
		}
	
	}
	
	/*
	 * This test checks if you win a game, then it should be written to the highscore
	 */
	public void testWin() {
		act = getActivity();
		HighscoreHandler handler = HighscoreHandler.getInstance();
		handler.deleteScores(1);
		int count_highscore = handler.getHighscore(null, 1);
		assertTrue(count_highscore == 0);
		act.win();
		count_highscore = handler.getHighscore(null, 1);
		assertTrue(count_highscore == 1);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
