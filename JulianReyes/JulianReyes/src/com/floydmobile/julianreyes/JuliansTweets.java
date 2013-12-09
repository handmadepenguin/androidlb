package com.floydmobile.julianreyes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;

public class JuliansTweets extends Activity {

	private TextView viewerM;
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    /*
	     Just for testing, allow network access in the main thread
	     NEVER use this is productive code
	     */
	    StrictMode.ThreadPolicy policy = new StrictMode.
	    ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy); 
	    
	    
	    setContentView(R.layout.julianstweets);
	    viewerM = (TextView) findViewById(R.id.tweetsection);
	    String readTwitterFeed = readTwitterFeed();
	    StringBuilder builder = new StringBuilder();
	    try {
	      JSONObject jsonObject2 = new JSONObject(readTwitterFeed);
	      JSONArray jsonArray = jsonObject2.getJSONArray("users");
	      Log.i(JuliansTweets.class.getName(),
	          "Number of entries " + jsonArray.length());
	      for (int i = 0; i < jsonArray.length(); i++) {
	        JSONObject jsonObject = jsonArray.getJSONObject(i);
	        String temp;
	        temp = jsonObject.getString("firstname");
	        Log.i(JuliansTweets.class.getName(), jsonObject.getString("firstname"));
	        builder.append(temp);
	      }
	      viewerM.setText(builder);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	
	public String readTwitterFeed() {
	    StringBuilder builder = new StringBuilder();
	    HttpClient client = new DefaultHttpClient();
	    HttpGet httpGet = new HttpGet("http://www.floydmobile.com/JSONTests/jsontest.php");
	    try {
	      HttpResponse response = client.execute(httpGet);
	      StatusLine statusLine = response.getStatusLine();
	      int statusCode = statusLine.getStatusCode();
	      if (statusCode == 200) {
	        HttpEntity entity = response.getEntity();
	        InputStream content = entity.getContent();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
	        String line;
	        while ((line = reader.readLine()) != null) {
	          builder.append(line);
	        }
	      } else {
	        Log.e(JuliansTweets.class.toString(), "Failed to download file");
	      }
	    } catch (ClientProtocolException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return builder.toString();
	  }
}
