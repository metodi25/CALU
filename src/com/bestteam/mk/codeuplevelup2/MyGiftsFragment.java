package com.bestteam.mk.codeuplevelup2;


import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;



import com.bestteam.mk.codeuplevelup2.listView.GiftAdapter;

public class MyGiftsFragment extends Fragment {

	private static final String ARG_SECTION_NUMBER = "section_number";
ImageButton plusButton1;
ImageButton plusButton2;
ListView listView1;
ArrayList<String> myArraylistString;
ArrayList<Boolean> myArraylistBoolean;
	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static MyGiftsFragment newInstance(int sectionNumber) {
		MyGiftsFragment fragment = new MyGiftsFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public MyGiftsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_my_gifts, container, false);
		getActionBar().setTitle("My WishList");
		
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		        "Blackberry", "WebOS", "wasddaw", "asdasda", "asdasdadadasd" };
		Boolean[] b = new Boolean[] {true,false,true,true,false,true,false, false};
		
		myArraylistString = new ArrayList<String>();
		myArraylistBoolean = new ArrayList<Boolean>();
		
		for(int i = 1; i<values.length;i++)
		{
			myArraylistString.add(values[i]);
			myArraylistBoolean.add(b[i]);
		}
		
		
		
		listView1 = (ListView) rootView.findViewById(R.id.main_List_gifts);
		plusButton1 = (ImageButton) rootView.findViewById(R.id.button_plus1);
		plusButton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
				adb.setTitle("Rosana");
				adb.setMessage("tuka treba da ima nekakva poraka so rosana seuste ja nema smisleno");
				
				adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					Toast.makeText(getActivity(), "jeeeeeeeeej", Toast.LENGTH_SHORT);
					}
					
				});

				adb.setIcon(R.drawable.ic_launcher);
				adb.show();
			}
		});
		
		plusButton2 = (ImageButton) rootView.findViewById(R.id.button_plus2);
		plusButton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
				adb.setTitle("Rosana");
				adb.setMessage("poklon blabla");
				
				adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						myArraylistString.add("poklon blabla");
						myArraylistBoolean.add(true);
						  GiftAdapter myadapter = new GiftAdapter(getActivity(), myArraylistString,myArraylistBoolean);
						  listView1.setSelector( R.drawable.list_selector);
						             
						             listView1.setAdapter(myadapter);
						
//					Toast.makeText(getActivity(), "jeeeeeeeeej", Toast.LENGTH_SHORT);
					}
					
				});

				adb.setIcon(R.drawable.ic_launcher);
				adb.show();
			}
		});
		
		
		
		
		
		    GiftAdapter myadapter = new GiftAdapter(getActivity(), myArraylistString,myArraylistBoolean);
 listView1.setSelector( R.drawable.list_selector);
            
            listView1.setAdapter(myadapter);
		
		return rootView;
	}

	private ActionBar getActionBar() {
		return ((ActionBarActivity) getActivity()).getSupportActionBar();
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
//		((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
	}

}
