package mobileapps.agame;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Class to handle level one fragment
 * @author karin wilding
 */
public class LevelOneFragment extends Fragment {
	static View view1;
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	        // Inflate the layout for this fragment	 
		 	view1 = inflater.inflate(R.layout.fragment_level_one, container, false);
		 	
		 	HighscoreHandler.getInstance().getHighscore(view1, 1);
		 			 	
			return view1;
	    }	 

} 