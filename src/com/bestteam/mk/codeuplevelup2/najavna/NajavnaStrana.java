package com.bestteam.mk.codeuplevelup2.najavna;



import com.bestteam.mk.codeuplevelup2.MainActivity;
import com.bestteam.mk.codeuplevelup2.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class NajavnaStrana extends Activity {

	public static String filename = "MySharedPort";
	// SharedPreferences someData;
	SharedPreferences someData;

	EditText username;
	EditText password;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		someData = getSharedPreferences(filename, 0); // defoult loader zamisli
														// go kako folder

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			if (extras.getString("najava").equalsIgnoreCase("najava")) {

				SharedPreferences.Editor editor = someData.edit(); // namenata
																	// na
																	// SharedPreferences
																	// klasata e
																	// samo da
																	// zacuva
																	// vakvi
																	// vidovi na
																	// fajlovi(bolean(on,
																	// of),
																	// string...)
				editor.putString("sharedString", "nisto"); // "kreairaj sharedpreff vo somedata folderot"
															// mozeme da
															// zacuvame poveke
															// stringovi sto
															// mozeme da gi
															// koristeme podocna
				editor.commit();
			}

		}

		String dataReturned = someData.getString("sharedString", "nistoo");
		// Toast.makeText(this,
		// "Ova e stringot"+dataReturned,Toast.LENGTH_LONG).show();
		if (!dataReturned.equalsIgnoreCase("83")) {
			setContentView(R.layout.activity_najavna);
			ImageButton login = (ImageButton) findViewById(R.id.login);
			username = (EditText) findViewById(R.id.username);
			password = (EditText) findViewById(R.id.password);
		} else {

			
			this.finish();
		}

	}

	public void login(View v) {
		String usernamedata = username.getText().toString();
		String passworddata = password.getText().toString();
		System.out.println("username:" + usernamedata + "pass:" + passworddata);

		if (usernamedata.equalsIgnoreCase("calu")
				&& passworddata.equalsIgnoreCase("calu2014")) {

//			Intent intent = new Intent(getApplicationContext(),
//					SpalshScreenActivity.class);
//			intent.putExtra("portId", "80");
			startActivity(new Intent(NajavnaStrana.this, MainActivity.class));

			this.finish();
		
		} else
			Toast.makeText(this, "Wrong username or password",
					Toast.LENGTH_LONG).show();

	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
		android.os.Process.killProcess(android.os.Process.myPid());
	}

}
