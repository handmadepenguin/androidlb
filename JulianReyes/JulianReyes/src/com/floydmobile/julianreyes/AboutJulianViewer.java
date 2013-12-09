package com.floydmobile.julianreyes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class AboutJulianViewer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_julian_view);
		Intent launchingIntent = getIntent();
        String content = launchingIntent.getData().toString();
        TextView textView = (TextView) findViewById(R.id.TextViewTitle);
        textView.setText(content);
	}
}
