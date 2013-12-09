package com.floydmobile.julianreyes;

import java.util.ArrayList;

//import com.examples.youtubeapidemo.IntentsDemoActivity.IntentItem;
//import com.examples.youtubeapidemo.IntentsDemoActivity.IntentType;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class VideosTable extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b=this.getIntent().getExtras();
		ArrayList<String> phototitles = new ArrayList<String>();
		phototitles = b.getStringArrayList("titles");
		
		ArrayList<String> photourls = new ArrayList<String>();
		photourls = b.getStringArrayList("urls");
		ArrayAdapter<String> arrayAdapter =      
                new ArrayAdapter<String>(this,R.layout.list_item, phototitles);
		setListAdapter(arrayAdapter);
		final String[] links = photourls.toArray(new String[photourls.size()]);
		getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				String content = links[position];
				String pattern = "src=\"http://www.youtube.com/embed/";
				String[] updated = content.split(pattern);
				
				String[] strippedurl = updated[1].split("\\?");
				content = strippedurl[0];
				
				Log.e(VideosTable.class.toString(), strippedurl[0]);
				
			    Intent showContent = new Intent(getApplicationContext(),
			            YouTubeAPITest.class);
			    showContent.putExtra("video", content);
			    startActivity(showContent);
			            
				//intent = YouTubeIntents.createPlayVideoIntentWithOptions(, content, true, false);
		        //startActivity(intent);
				//startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=HKdsra1O20Y#t=30m10s")));
			    //showContent.putExtra("url", updated[1]);
			    //showContent.putExtra("url", content);
			    //showContent.setData(Uri.parse(content));
			    //startActivity(showContent);
			}
		});
		
		//Log.e(MainActivity.class.toString(), photourls.toString());
		//Log.e(MainActivity.class.toString(), phototitles.toString());
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
