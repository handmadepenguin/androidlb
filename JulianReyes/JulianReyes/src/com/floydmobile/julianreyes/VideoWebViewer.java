package com.floydmobile.julianreyes;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class VideoWebViewer extends Activity {
	private WebView webView;
	
	public void onCreate(Bundle saveState) {

	    super.onCreate(saveState);
	    setContentView(R.layout.video_webview);
	    Intent launchingIntent = getIntent();
        Bundle extas = launchingIntent.getExtras();
        String videoURL = extas.getString("url");
	    webView = (WebView) findViewById(R.id.webview1);
	    //webView.getSettings().setPluginState(on);
	    webView.getSettings().setJavaScriptEnabled(true);

	    webView.loadUrl(videoURL);

	//  String customHtml = "<html><body><h1>Hello, WebView</h1></body></html>";
	//  webView.loadData(customHtml, "text/html", "UTF-8");



	}
}
