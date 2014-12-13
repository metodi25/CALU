package com.bestnetstudio.gifts;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;






public class MainActivity extends Activity {
	ListView list;
	TextView ver;
	TextView name;
	TextView api;
	Button Btngetdata;
	ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();
	
	//URL to get JSON Array
	private static String url ="http://bestnetstudio.com/gifts.php"; //"http://api.learn2crack.com/android/jsonos/";
	
	//JSON Node Names 
	private static final String TAG_OS = "android";
	private static final String TAG_VER = "id";
	private static final String TAG_NAME = "name";
	private static final String TAG_API = "selected";
	
	JSONArray android = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.activity_main);
        oslist = new ArrayList<HashMap<String, String>>();

        new JSONParse().execute();
        
    /*    Btngetdata = (Button)findViewById(R.id.getdata);
        Btngetdata.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
		       

				
			}
		});
        
      */  
    }


    
    private class JSONParse extends AsyncTask<String, String, JSONObject> {
    	 private ProgressDialog pDialog;
    	@Override
        protected void onPreExecute() {
            super.onPreExecute();
           //  ver = (TextView)findViewById(R.id.vers);
			 name = (TextView)findViewById(R.id.name);
			// api = (TextView)findViewById(R.id.api);
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
            
            
            
    	}
    	
    	@Override
        protected JSONObject doInBackground(String... args) {
    		
    		JSONParser jParser = new JSONParser();

    		// Getting JSON from URL
    		JSONObject json = jParser.getJSONFromUrl(url);
    		return json;
    	}
    	 @Override
         protected void onPostExecute(JSONObject json) {
    		 pDialog.dismiss();
    		 try {
    				// Getting JSON Array from URL
    				android = json.getJSONArray(TAG_OS);
    				for(int i = 0; i < android.length(); i++){
    				JSONObject c = android.getJSONObject(i);
    				
    				// Storing  JSON item in a Variable
    				String ver = c.getString(TAG_VER);
    				String name = c.getString(TAG_NAME);
    				String api = c.getString(TAG_API);
    				
    			
    				
    				
    				// Adding value HashMap key => value
    				

    				HashMap<String, String> map = new HashMap<String, String>();

    				map.put(TAG_VER, ver);
    				map.put(TAG_NAME, name);
    				map.put(TAG_API, api);
    				
    				oslist.add(map);
    				list=(ListView)findViewById(R.id.list);
    				
    				
    				
    		        
    				
    				ListAdapter adapter = new SimpleAdapter(MainActivity.this, oslist,
    						R.layout.list_v,
    					//	new String[] { TAG_VER,TAG_NAME, TAG_API }, new int[] {
    						//		R.id.vers,R.id.name, R.id.api});
    				new String[] {TAG_NAME }, new int[] {
							R.id.name});

    				list.setAdapter(adapter);
    				
    				list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    		            @Override
    		            public void onItemClick(AdapterView<?> parent, View view,
    		                                    int position, long id) {
    		                Toast.makeText(MainActivity.this, "You Clicked at "+oslist.get(+position).get("name"), Toast.LENGTH_SHORT).show();

    		            }
    		        });

    				}
    		} catch (JSONException e) {
    			e.printStackTrace();
    		}

    		 
    	 }
    }
    
}






JSONParser.java
package com.bestnetstudio.gifts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONParser {

	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";

	// constructor
	public JSONParser() {

	}

	public JSONObject getJSONFromUrl(String url) {

		// Making HTTP request
		try {
			// defaultHttpClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();			

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
		}

		// try parse the string to a JSON object
		try {
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
		}

		// return JSON String
		return jObj;

	}
}
