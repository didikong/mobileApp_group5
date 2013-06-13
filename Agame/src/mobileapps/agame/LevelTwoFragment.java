package mobileapps.agame;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Class to handle level two fragment
 * @author karin wilding
 */
public class LevelTwoFragment extends Fragment {
	 static View view2;
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
		 	view2 = inflater.inflate(R.layout.fragment_level_two, container, false);
		 	
		 	HighscoreHandler.getInstance().getHighscore(view2, 2);
		 	
			return view2;
	    }
 
} 