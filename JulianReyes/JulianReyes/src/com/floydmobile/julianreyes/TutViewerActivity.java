package com.floydmobile.julianreyes;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class TutViewerActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tut_view);
		Intent launchingIntent = getIntent();
        String content = launchingIntent.getData().toString();
        WebView viewer = (WebView) findViewById(R.id.tutView);
        viewer.loadUrl(content);
	}
}
