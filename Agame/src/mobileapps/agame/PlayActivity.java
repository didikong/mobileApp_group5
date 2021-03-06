package mobileapps.agame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends Activity {
	
	private String[] calc;
	private String[] result;
	private int[] map;
	private int max;
	private int number_of_rows;
	private int[] takenCoord;
	private boolean taken;
	
	private Button hide1;
	private Button hide2;
	
	private int wincounter;
	private long start;
	
	private int level;
	private boolean hide;
	
	/*
	 * this method is called when the activity is created
	 * it inits the game and starts the timer
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        
        Bundle extra = getIntent().getExtras();
        if(extra == null) {
        	level = 1;
        }
        else {
        	level = (int) extra.getInt("Level");
        }
        
        takenCoord = new int[2];
        taken = false;
        hide = false;
        number_of_rows = 8;
        wincounter = 0;
        calc = new String[number_of_rows];
        result = new String[number_of_rows];
        map = new int[number_of_rows];
        switch(level) {
        case 1:
        	max = 9;
        	break;
        case 2:
        	max = 50;
        	break;
        case 3:
        	max = 500;
        	break;
        }
        initArrays();
        //printArrays();
        startThread();
        start = System.currentTimeMillis();
        
        /* home/ up button */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}


	/*
	 * this method handles the home and the help button
	 */
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
		intent.putExtra("HELP_SETTINGS", 1);
		startActivity(intent);
	}
    
	/*
	 * if you click on a card, this method show the text of the buttons,
	 * and checks if card have to be hide or not.
	 */
    public void onClickCard (View view) {
    	int id = view.getId();
    	Button pressedButton = (Button) findViewById(id);
    	int row = Integer.parseInt((String) pressedButton.getTag()) / 10;
    	int column = Integer.parseInt((String) pressedButton.getTag()) % 10;
    	
    	if(pressedButton.getText().length()>0) {
    		return;
    	}
    	if(hide2 != null) {
    		return;
    	}
    	
    	if(!taken || takenCoord[1] != column) {
    		
	    	if(column == 0) {
	        	pressedButton.setText(calc[row]);
	        	if(taken && map[takenCoord[0]] != row) {
	        		hide2 = pressedButton;
	        		hide = true;
	        	}
	        	else if(taken) {
	        		//hide1.setBackgroundColor(Color.MAGENTA);
	        		//pressedButton.setBackgroundColor(Color.MAGENTA);
	        		hide1 = null;
	        		hide2 = null;
	        		wincounter++;
	        	}
	    	}
	    	else {
	        	pressedButton.setText(result[row]);
	        	if(taken && map[row] != takenCoord[0]) {
	        		hide2 = pressedButton;
	        		hide = true;
	        	}
	        	else if(taken){
	        		//hide1.setBackgroundColor(Color.MAGENTA);
	        		//pressedButton.setBackgroundColor(Color.MAGENTA);
	        		hide1 = null;
	        		hide2 = null;
	        		wincounter++;
	        	}
	    	}
	    	
	    	if(!taken) {
	    		hide1 = pressedButton;
	    	}
	    	
	    	takenCoord[0] = row;
    		takenCoord[1] = column;
    		taken = !taken;
    		
    		if(wincounter == number_of_rows) {
    			win();
    		}
    	}
    }
    
    /*
     * This method inits the calc and result array and the map.
     */
    private void initArrays() {
    	int value1;
		int value2;
		int value3;
    	for(int i = 0; i<number_of_rows; i++) {
    		do {
	    		value1 = 1+(int)(Math.random()*max);
	    		value2 = 1+(int)(Math.random()*max);
	    		value3 = value1 + value2;
	    		System.out.println(value3);
    		}
	    	while(containResult(value3));
    		
    		calc[i] = Integer.toString(value1) + " + " + Integer.toString(value2);
    		result[i] = Integer.toString(value3);
        	map[i] = i;
        }
    	swap();
    }
    
    /*
     * this method checks if one value is already in the result
     */
    private boolean containResult(int value) {
    	for(int i = 0; i<number_of_rows; i++) {
    		if(result[i] == null) {
    			continue;
    		}
    		if(Integer.parseInt(result[i]) == value) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /*
     * This method swap the result array very often, to get a random map
     */
    private void swap() {
    	for(int i = 0; i<3*number_of_rows; i++) {
    		int value1 = (int)(Math.random()*(number_of_rows));
    		int value2 = (int)(Math.random()*(number_of_rows));
    		String save = result[value1];
    		result[value1] = result[value2];
    		result[value2] = save;
    		int save2 = map[value1];
    		map[value1] = map[value2];
    		map[value2] = save2;
    	}
    }
    
    /*
     * This method starts a thread, which checks if the text of two buttons
     * should be hidden and hide them.
     */
    public void startThread() {
    	
    	new Thread(new Runnable() {
			
			public void run() {
				while(true) {
					try {
						if(hide) {
							Thread.sleep(20);
						}
						else {
							Thread.sleep(2500);
							System.out.println("hide");
							runOnUiThread(new Runnable() {
									
								public void run() {
									if(hide1 != null && hide2 != null) {
										hide1.setText("");
										hide2.setText("");
										hide1 = null;
										hide2 = null;
										hide = false;
									}
								}
							});
						}
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
    }
    
    /*
     * This method prints the calc-, result-, and the map array 
     */
    public void printArrays() {
    	for(int i = 0; i < number_of_rows; i++) {
    		System.out.println(calc[i] + "  " + result[i] + "  " + i + "  " + map[i]);
    	}
    }
    
    /*
     * This method is called when the game is over. It puts the time into the
     * highscore and start the highscore activity.
     */
    public void win() {
    	long time = System.currentTimeMillis() - start;
    	HighscoreHandler.getInstance().calculateHighscore(level, (int)time);
    	
    	Intent intent = new Intent(this, HighscoreActivity.class);
		startActivity(intent);
    	
    	finish();
    }
    
    /*
     * returns the calc array
     */
    public String[] getCalc() {
    	return calc;
    }
    
    /*
     * returns the result array
     */
    public String[] getResult() {
    	return result;
    }
    
    /*
     * returns the map array
     */
    public int[] getMap() {
    	return map;
    }

}
