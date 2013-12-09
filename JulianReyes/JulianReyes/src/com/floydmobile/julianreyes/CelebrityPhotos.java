package com.floydmobile.julianreyes;

import java.util.ArrayList;

import android.app.ListActivity;
import com.floydmobile.julianreyes.R;
import com.floydmobile.julianreyes.PictureViewer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.ArrayAdapter;

public class CelebrityPhotos extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b=this.getIntent().getExtras();
		ArrayList<String> phototitles = new ArrayList<String>();
		phototitles = b.getStringArrayList("phototitles");
		
		ArrayList<String> photourls = new ArrayList<String>();
		photourls = b.getStringArrayList("photourls");
		ArrayAdapter<String> arrayAdapter =      
                new ArrayAdapter<String>(this,R.layout.list_item, phototitles);
		setListAdapter(arrayAdapter);
		final String[] links = photourls.toArray(new String[photourls.size()]);
		getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				String content = links[position];
			    Intent showContent = new Intent(getApplicationContext(),
			            PictureViewer.class);
			    //Log.e(MainActivity.class.toString(), content.toString());
			    showContent.putExtra("url", content);
			    startActivity(showContent);
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
