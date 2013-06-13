package mobileapps.agame.test;

import com.jayway.android.robotium.solo.Solo;

import mobileapps.agame.PlayActivity;
import mobileapps.agame.R;
import android.test.ActivityInstrumentationTestCase2;
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
	
	public void testInit() {
		act = getActivity();
		String[] calc = act.getCalc();
		String[] result = act.getResult();
		int[] map = act.getMap();
		assertNotNull(calc);
		assertNotNull(result);
		assertNotNull(map);
		
		int size = map.length;
		for(int i = 0; i < size; i++) {
			String[] split = calc[map[i]].split(" ");
			int value1 = Integer.parseInt(split[0]);
			int value2 = Integer.parseInt(split[2]);
			int value3 = Integer.parseInt(result[i]);
			assertTrue(value1 + value2 == value3);
		}
	}
	
	public void testButtons() {
		assertEquals("Hello", "Hello");
		
	}
	
	public void testHide() {
		// at the start the buttons have no text
		Button button00 = (Button)solo.getView(R.string.button00);
		assertEquals("", button00.getText());
		Button button01 = (Button)solo.getView(R.string.button01);
		assertEquals("", button01.getText());
		solo.sleep(500);
		
		//click the first button
		solo.clickOnText(getActivity().getResources().getString(R.string.button00));
		String calc = (String) button00.getText();
		assertTrue(!calc.equals(""));
		solo.sleep(500);
		
		//click the first button
		solo.clickOnText(getActivity().getResources().getString(R.string.button01));
		String result = (String) button00.getText();
		assertTrue(!result.equals(""));
		solo.sleep(500);
		
		//check if there are the same
		String[] splitResult = calc.split(" ");
		int value1 = Integer.parseInt(splitResult[0]);
		int value2 = Integer.parseInt(splitResult[2]);
		
		solo.sleep(5000);
		
		//Text didn't hide
		if(value1 + value2 == Integer.parseInt(result)) {
			assertTrue(!calc.equals(""));
			assertTrue(!result.equals(""));
		}
		//Text is be hide
		else {
			assertEquals("", button00.getText());
			assertEquals("", button01.getText());
		}
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
