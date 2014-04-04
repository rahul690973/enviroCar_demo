package com.example.envirocar;

import java.io.InputStream;


import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button button_mpg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		// I am calling the track with trackid 533ecbfde4b09d7b34f80643
		//and since there are many measurement values included in it
		// for different co-ordinates, i am calling the measurement
		//with measurement id 533ecbfde4b09d7b34f80645
		
		 button_mpg=(Button)findViewById(R.id.button_mpg);
		 new fetchData().execute();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	class fetchData extends AsyncTask<String, String, Void>
	{
	 InputStream is = null ;
	 String result = "",response="";
	 
	 protected void onPreExecute() {
	    
	  }
	    @Override
		protected Void doInBackground(String... params) {
	    	
	  	  String url_select = "https://envirocar.org/api/stable/tracks/533ecbfde4b09d7b34f80643/measurements/533ecbfde4b09d7b34f80645";
		  DefaultHttpClient client = new DefaultHttpClient();
	      HttpGet httpPost = new HttpGet(url_select);
	      
		 
		    try {
		    	
		    	ResponseHandler<String> responseHandler = new BasicResponseHandler();
		    	response = client.execute(httpPost, responseHandler);
			
			
		    }catch (Exception e) {

		    	Log.e("http_error", "Error in http connection "+e.toString());
		    	
			}
				return null;
	   }	
		
	    protected void onPostExecute(Void v) {
		
			 try{
			 
				 JSONObject json = new JSONObject(response);
				 JSONObject properties=(JSONObject) json.get("properties");//get the properties list
				 JSONObject phenomenons=(JSONObject) properties.get("phenomenons"); // get all phenomenons
				 
				 
				 JSONObject consumption=(JSONObject) phenomenons.get("Consumption");
				 Double consumption_value=(Double) consumption.get("value");   //consumtion value in l/h
				 
				 JSONObject speed=(JSONObject) phenomenons.get("Speed");       
				 Double speed_value=(Double) speed.get("value");               //speed in km/h
				 
				 Double consumption_lkm=(consumption_value/speed_value);       //consumption in l/km
				 Double mpg_value=consumption_lkm*2.35214583;               // 1 l/km= 2.35214583 Miles per gallon
				
				 button_mpg.setText(mpg_value.toString());
				 
				 
				 
				 Log.d("mpg_value",mpg_value.toString());
				 
			     
		 }
		 
			catch(JSONException e){
	            Log.e("log_tag", "Error parsing data "+e.toString());
	    }
	    
	 }
	           
	}
	
	

}