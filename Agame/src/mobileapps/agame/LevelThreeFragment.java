package mobileapps.agame;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Class to handle level three fragment
 * @author karin wilding
 */
public class LevelThreeFragment extends Fragment {
	   
		
	static View view3;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
	 	view3 = inflater.inflate(R.layout.fragment_level_three, container, false);
	 	
	 	HighscoreHandler.getInstance().getHighscore(view3, 3);
	 	
		return view3;
    }
 
} 