package mobileapps.agame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

/**
 * Class to handle high score calculation as well as setting and getting of high score list.
 * @author karin wilding
 */
public class HighscoreHandler extends Activity {

	private static HighscoreHandler instance = null;
	   protected HighscoreHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static HighscoreHandler getInstance() {
	      if(instance == null) {
	         instance = new HighscoreHandler();
	      }
	      return instance;
	   }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	/** calculates new high score after a game */
	public void calculateHighscore(int level, int seconds) {
		String filename;		
		switch (level) {
	        case 1:
	        	filename = Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelOne.txt";
	            break;
	        case 2:
	        	filename = Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelTwo.txt";
	            break;
	        case 3:
	        	filename = Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelThree.txt";
	            break;
	        default:
	        	filename = "";
	        	//Toast t = new Toast(null);
		}
		
		File myFile = new File(filename);
		// if file exists already:
		if(myFile.exists())
		{	
			// read to list
			Scanner sc;
			List<Integer> lines = null;
			try {
				sc = new Scanner(new File(filename));
				lines = new ArrayList<Integer>();
				while (sc.hasNextLine()) {
				  lines.add(Integer.parseInt(sc.nextLine()));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			// sort and add new value at right position
			Collections.sort( lines );
			int amount = lines.size();
			for (int i = 0; i < amount; i++) {
				if(lines.get(i) > seconds) {
					lines.add(seconds);
					Collections.sort( lines );
					break;
				}
				else if(lines.size() < 5) {
					lines.add(seconds);
					Collections.sort( lines );
					break;
				}
				
			}
			while(lines.size() > 5) {
				lines.remove(lines.size()-1);
			}
			
			File newFile = new File(filename);
			try {
				myFile.delete();
				newFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int j = 0; j < lines.size(); j++) {
				HighscoreHandler.getInstance().setHighscore(newFile, lines.get(j));
			}
		}
		else {
			try {
				myFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HighscoreHandler.getInstance().setHighscore(myFile, seconds);
		}
		
	
	}
	
	/** gets high score and converts it to ListView */
	public int getHighscore(View view, int level) {
		String filename;
		switch (level) {
	        case 1:
	            filename = Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelOne.txt";
	            break;
	        case 2:
	        	filename = Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelTwo.txt";
	            break;
	        case 3:
	        	filename = Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelThree.txt";
	            break;
	        default:
	        	filename = "";
	        	//Toast t = new Toast(null);
		}

		File logFile = new File(filename);
	
		int[] ids = {R.id.text_one, R.id.text_two, R.id.text_three, R.id.text_four, R.id.text_five};

		int counter = 0;
		if(logFile.exists()) {
			BufferedReader input;
			try {
				input = new BufferedReader(new FileReader(logFile));
				String line = null;
				while (( line = input.readLine()) != null){
					if(view != null) {
						TextView tv = (TextView)view.findViewById(ids[counter]);
						tv.setText(line);
					}
					counter = counter + 1;
				}
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
       return counter;
	}
	
	/** sets high score new */
	public void setHighscore(File myFile, int seconds) {
	
		try {		
			BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
			bw.write(Integer.toString(seconds));
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteScores(int level) {	
		switch (level) {
		case 0:
			File logFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelOne.txt");
			logFile.delete();
			TextView tv11 = (TextView)LevelOneFragment.view1.findViewById(R.id.text_one);
			tv11.setText("-");
			TextView tv12 = (TextView)LevelOneFragment.view1.findViewById(R.id.text_two);
			tv12.setText("-");
			TextView tv13 = (TextView)LevelOneFragment.view1.findViewById(R.id.text_three);
			tv13.setText("-");
			TextView tv14 = (TextView)LevelOneFragment.view1.findViewById(R.id.text_four);
			tv14.setText("-");
			TextView tv15 = (TextView)LevelOneFragment.view1.findViewById(R.id.text_five);
			tv15.setText("-");
			break;
		case 1:
			File logFile2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelTwo.txt");
			logFile2.delete();
			TextView tv21 = (TextView)LevelTwoFragment.view2.findViewById(R.id.text_one);
			tv21.setText("-");
			TextView tv22 = (TextView)LevelTwoFragment.view2.findViewById(R.id.text_two);
			tv22.setText("-");
			TextView tv23 = (TextView)LevelTwoFragment.view2.findViewById(R.id.text_three);
			tv23.setText("-");
			TextView tv24 = (TextView)LevelTwoFragment.view2.findViewById(R.id.text_four);
			tv24.setText("-");
			TextView tv25 = (TextView)LevelTwoFragment.view2.findViewById(R.id.text_five);
			tv25.setText("-");
			break;
		case 3:
			File logFile3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelThree.txt");
			logFile3.delete();
			TextView tv31 = (TextView)LevelThreeFragment.view3.findViewById(R.id.text_one);
			tv31.setText("-");
			TextView tv32 = (TextView)LevelThreeFragment.view3.findViewById(R.id.text_two);
			tv32.setText("-");
			TextView tv33 = (TextView)LevelThreeFragment.view3.findViewById(R.id.text_three);
			tv33.setText("-");
			TextView tv34 = (TextView)LevelThreeFragment.view3.findViewById(R.id.text_four);
			tv34.setText("-");
			TextView tv35 = (TextView)LevelThreeFragment.view3.findViewById(R.id.text_five);
			tv35.setText("-");
			break;
		/*default:
			File logFiled1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelOne.txt");
			logFiled1.delete();
			TextView tv11d1 = (TextView)LevelOneFragment.view1.findViewById(R.id.text_one);
			tv11d1.setText("-");
			TextView tv12d1 = (TextView)LevelOneFragment.view1.findViewById(R.id.text_two);
			tv12d1.setText("-");
			TextView tv13d1 = (TextView)LevelOneFragment.view1.findViewById(R.id.text_three);
			tv13d1.setText("-");
			TextView tv14d1 = (TextView)LevelOneFragment.view1.findViewById(R.id.text_four);
			tv14d1.setText("-");
			TextView tv15d1 = (TextView)LevelOneFragment.view1.findViewById(R.id.text_five);
			tv15d1.setText("-");
			File logFile2d2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelTwo.txt");
			logFile2d2.delete();
			TextView tv21d2 = (TextView)LevelTwoFragment.view2.findViewById(R.id.text_one);
			tv21d2.setText("-");
			TextView tv22d2 = (TextView)LevelTwoFragment.view2.findViewById(R.id.text_two);
			tv22d2.setText("-");
			TextView tv23d2 = (TextView)LevelTwoFragment.view2.findViewById(R.id.text_three);
			tv23d2.setText("-");
			TextView tv24d2 = (TextView)LevelTwoFragment.view2.findViewById(R.id.text_four);
			tv24d2.setText("-");
			TextView tv25d2 = (TextView)LevelTwoFragment.view2.findViewById(R.id.text_five);
			tv25d2.setText("-");
			File logFile3d3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/HighscoreLevelThree.txt");
			logFile3d3.delete();
			TextView tv31d3 = (TextView)LevelThreeFragment.view3.findViewById(R.id.text_one);
			tv31d3.setText("-");
			TextView tv32d3 = (TextView)LevelThreeFragment.view3.findViewById(R.id.text_two);
			tv32d3.setText("-");
			TextView tv33d3 = (TextView)LevelThreeFragment.view3.findViewById(R.id.text_three);
			tv33d3.setText("-");
			TextView tv34d3 = (TextView)LevelThreeFragment.view3.findViewById(R.id.text_four);
			tv34d3.setText("-");
			TextView tv35d3 = (TextView)LevelThreeFragment.view3.findViewById(R.id.text_five);
			tv35d3.setText("-");
			break;*/
		}
	}
}
