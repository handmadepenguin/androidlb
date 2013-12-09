package com.floydmobile.julianreyes;

import java.util.ArrayList;

import org.json.*;

import com.floydmobile.julianreyes.R;
import com.floydmobile.julianreyes.TutViewerActivity;
import com.floydmobile.julianreyes.AboutJulianActivity;
//import com.floydmobile.julianreyes.JuliansTweets;
import com.floydmobile.julianreyes.CelebrityPhotos;
import com.loopj.android.http.*;

import android.os.Bundle;
import android.app.ListActivity;
//import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.content.Intent;
import android.net.Uri;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.tut_titles, R.layout.list_item));
		final String[] links = getResources().getStringArray(R.array.tut_links);
		//setContentView(R.layout.activity_main);
		
		//ListView listView = getListView();
				getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {
						// TODO Auto-generated method stub
						if (position == 0) {
							Intent aboutJulianList = new Intent(getApplicationContext(),
									AboutJulianActivity.class);
							startActivity(aboutJulianList);
						}else if (position == 1){
							Intent youtubeapitest = new Intent(getApplicationContext(),
									YouTubeAPITest.class);
							startActivity(youtubeapitest);
						}else if (position == 2) {
							AsyncHttpClient client = new AsyncHttpClient();
							client.get("http://www.floydmobile.com/julianreyes/jrvideosegment.php", new JsonHttpResponseHandler() {
							    @Override
							    public void onSuccess(org.json.JSONObject response) {
							    	
									JSONArray photos=null;
									JSONObject photo=null;
	
									ArrayList<String> photourls = new ArrayList<String>();
									ArrayList<String> phototitles = new ArrayList<String>();
									try {
										photos = response.getJSONArray("vlog");
										for (int i = 0; i < photos.length(); i++) { 
											photo = photos.getJSONObject(i);
											photourls.add(photo.getString("url"));
											phototitles.add(photo.getString("name"));
										}
										Bundle b=new Bundle();
										b.putStringArrayList("urls", photourls);
										b.putStringArrayList("titles", phototitles);
										Intent i=new Intent(getApplicationContext(), VideosTable.class);
										i.putExtras(b);
										startActivity(i);
									} catch (JSONException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							    }
								});
						}else if (position == 3) {
							AsyncHttpClient client = new AsyncHttpClient();
							client.get("http://www.floydmobile.com/julianreyes/jrcelebrity.php", new JsonHttpResponseHandler() {
							    @Override
							    public void onSuccess(org.json.JSONObject response) {
							    	
									JSONArray photos=null;
									JSONObject photo=null;
	
									ArrayList<String> photourls = new ArrayList<String>();
									ArrayList<String> phototitles = new ArrayList<String>();
									try {
										photos = response.getJSONArray("photoblog");
										for (int i = 0; i < photos.length(); i++) { 
											photo = photos.getJSONObject(i);
											photourls.add(photo.getString("url"));
											phototitles.add(photo.getString("info"));
										}
										Bundle b=new Bundle();
										b.putStringArrayList("photourls", photourls);
										b.putStringArrayList("phototitles", phototitles);
										Intent i=new Intent(getApplicationContext(), CelebrityPhotos.class);
										i.putExtras(b);
										startActivity(i);
									} catch (JSONException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							    }
								});
							
						}else if (position == 4) {
							AsyncHttpClient client = new AsyncHttpClient();
							client.get("http://www.floydmobile.com/julianreyes/jrphotos.php", new JsonHttpResponseHandler() {
							    @Override
							    public void onSuccess(org.json.JSONObject response) {
							    	
									JSONArray photos=null;
									JSONObject photo=null;
	
									ArrayList<String> photourls = new ArrayList<String>();
									ArrayList<String> phototitles = new ArrayList<String>();
									try {
										photos = response.getJSONArray("photoblog");
										for (int i = 0; i < photos.length(); i++) { 
											photo = photos.getJSONObject(i);
											photourls.add(photo.getString("url"));
											phototitles.add(photo.getString("info"));
										}
										Bundle b=new Bundle();
										b.putStringArrayList("photourls", photourls);
										b.putStringArrayList("phototitles", phototitles);
										Intent i=new Intent(getApplicationContext(), CelebrityPhotos.class);
										i.putExtras(b);
										startActivity(i);
									} catch (JSONException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							    }
							});
						}
						else
						{
						String content = links[position];
					    Intent showContent = new Intent(getApplicationContext(),
					            TutViewerActivity.class);
					    showContent.setData(Uri.parse(content));
					    startActivity(showContent);
						}
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
