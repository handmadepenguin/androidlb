package com.floydmobile.julianreyes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.loopj.android.http.*;

public class PictureViewer extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.picture_viewer);
        
		AsyncHttpClient client = new AsyncHttpClient();
        String[] allowedTypes = new String[] { "image/png", "image/jpeg" };
        Intent launchingIntent = getIntent();
        Bundle extas = launchingIntent.getExtras();
        String content = extas.getString("url");
        client.get(content, new BinaryHttpResponseHandler(allowedTypes){
        	@Override
        	public void onSuccess(byte[] imageData) {
        		ImageView viewer = (ImageView) findViewById(R.id.imageView1);
                Bitmap bMap = BitmapFactory.decodeByteArray(imageData,0,imageData.length);
                viewer.setImageBitmap(bMap);
                Log.e(PictureViewer.class.toString(), "Download of image successfull");
        	}
        	
        	@SuppressWarnings("deprecation")
			@Override
        	public void onFailure(Throwable e, byte[] imageData) {
        		super.onFailure(e);
        		Log.e(PictureViewer.class.toString(), "Image Download Failed");
        	}
        });
        
	}
}
