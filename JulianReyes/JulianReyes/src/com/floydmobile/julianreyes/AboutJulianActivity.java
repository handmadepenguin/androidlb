package com.floydmobile.julianreyes;

import com.floydmobile.julianreyes.R;
import com.floydmobile.julianreyes.AboutJulianViewer;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.content.Intent;
import android.net.Uri;
import android.widget.ArrayAdapter;

public class AboutJulianActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.about_julian_titles, R.layout.list_item));
		final String[] textContent = getResources().getStringArray(R.array.about_julian_content);
		//setContentView(R.layout.activity_main);
		
		//ListView listView = getListView();
				getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {
						// TODO Auto-generated method stub
						String content = textContent[position];
					    Intent showContent = new Intent(getApplicationContext(),
					            AboutJulianViewer.class);
					    showContent.setData(Uri.parse(content));
					    startActivity(showContent);
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
