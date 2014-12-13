package com.bestteam.mk.codeuplevelup2.listView;

import java.util.ArrayList;

import com.bestteam.mk.codeuplevelup2.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GiftAdapter extends ArrayAdapter<String> {
  private final Context context;
  private final ArrayList<String> values;
  private final ArrayList<Boolean> slobodni;
   

  public GiftAdapter(Context context, ArrayList<String> values, ArrayList<Boolean> slobodni) {
    super(context, R.layout.list_item, values);
    this.context = context;
    this.values = values;
    this.slobodni = slobodni;
    
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.list_item, parent, false);
    TextView textView = (TextView) rowView.findViewById(R.id.list_text_view);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.list_image_view);
  
 // Change the icon and text
    ImageButton buttonIks = (ImageButton) rowView.findViewById(R.id.list_button);
    
    
      buttonIks.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 	values.remove(position);
			 	slobodni.remove(position);
			 	notifyDataSetChanged();
		//	 	Toast.makeText(getActivity(), "You have deleted row No. "+ position, Toast.LENGTH_SHORT).show();
			}
		});
    textView.setText(values.get(position));    
    if (slobodni.get(position)==true) {
    	
     imageView.setImageResource(R.drawable.orange_gift);
    } else {
      imageView.setImageResource(R.drawable.gray_gift);
    }

    return rowView;
  }
} 