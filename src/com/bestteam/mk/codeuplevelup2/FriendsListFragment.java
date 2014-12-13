package com.bestteam.mk.codeuplevelup2;

import com.bestteam.mk.codeuplevelup2.model.RoundedImage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter; 
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bestteam.mk.codeuplevelup2.friendspages.*;

public class FriendsListFragment extends Fragment {

	private static final String ARG_SECTION_NUMBER = "section_number";
//	private ImageView image1;
//	ImageButton imageButton1;
//	RoundedImage roundedImage;
//	RoundedImage roundedImage2;
	//ImageView image0;
	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static FriendsListFragment newInstance(int sectionNumber) {
		FriendsListFragment fragment = new FriendsListFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	

	public FriendsListFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_friends_list1, container, false);
		getActionBar().setTitle("My Friends");
		 ViewPager pager = (ViewPager) rootView.findViewById(R.id.viewPager);
	        pager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));
//		 image1 = (ImageView) rootView.findViewById(R.id.meto_friends1);
//	        image0= (ImageView) rootView.findViewById(R.id.meto_friends0);
//		 ImageView image2 = (ImageView) rootView.findViewById(R.id.meto_friends2);
//		 ImageView image3 = (ImageView) rootView.findViewById(R.id.meto_friends3);
//		 ImageView image4 = (ImageView) rootView.findViewById(R.id.meto_friends4);
//		 ImageView image5 = (ImageView) rootView.findViewById(R.id.meto_friends5);
//		 ImageView image6 = (ImageView) rootView.findViewById(R.id.meto_friends6);
//		 ImageView image7 = (ImageView) rootView.findViewById(R.id.meto_friends7);
//		 ImageView image8 = (ImageView) rootView.findViewById(R.id.meto_friends8);
//		// imageButton1 = (ImageButton) rootView.findViewById(R.id.imageButton1);
//		 Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.meto_1);
//         roundedImage = new RoundedImage(bm);
////         Bitmap bm2 = BitmapFactory.decodeResource(getResources(),R.drawable.aa);
////         roundedImage2 = new RoundedImage(bm2);
//     //    imageButton1.setImageDrawable(roundedImage);
//         image1.setImageDrawable(roundedImage);
//         image0.setImageDrawable(roundedImage);
//         image2.setImageDrawable(roundedImage);
//         image3.setImageDrawable(roundedImage);
//         image4.setImageDrawable(roundedImage);
//         image5.setImageDrawable(roundedImage);
//         image6.setImageDrawable(roundedImage);
//         image7.setImageDrawable(roundedImage);
//         image8.setImageDrawable(roundedImage);
//		 image0.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
//					adb.setTitle("Rosana");
//					adb.setMessage("tuka treba da ima nekakva poraka so rosana seuste ja nema smisleno");
//					
//					adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//						public void onClick(DialogInterface dialog, int id) {
//						Toast.makeText(getActivity(), "jeeeeeeeeej", Toast.LENGTH_SHORT);
//						}
//						
//					});
//				}});
		return rootView;
	}
	
	private class MyPagerAdapter extends FragmentStatePagerAdapter  {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

            case 0: return FirstFragment.newInstance("FirstFragment, Instance 1");
            case 1: return SecondFragment.newInstance("SecondFragment, Instance 1");
            case 2: return ThirdFragment.newInstance("ThirdFragment, Instance 1");
            default: return ThirdFragment.newInstance("ThirdFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 3;
        }       
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
