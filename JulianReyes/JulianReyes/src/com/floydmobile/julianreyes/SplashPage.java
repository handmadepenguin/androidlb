package com.floydmobile.julianreyes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class SplashPage extends Activity {
	// Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    private static int SPLASH_DISSOLVE = 2000;
    private static int SPLASH_SLIDEOUT = 2500;
    private ImageView presplash = null;
    private FrameLayout splashholder = null;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_page);
        presplash = ( ImageView )findViewById( R.id.imageView2 );
        splashholder = ( FrameLayout )findViewById( R.id.splashholder );
 
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashPage.this, CustomListViewAndroidExample.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
        new Handler().postDelayed(new Runnable() {
        	 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
            	// load the animation
            	Animation animFadeout;
                animFadeout = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadepresplash); 
                presplash.startAnimation(animFadeout);
            }
        }, SPLASH_DISSOLVE);
        new Handler().postDelayed(new Runnable() {
       	 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
            	// load the animation
            	Animation animFadeout;
                animFadeout = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.splash_slide_left_out); 
                splashholder.startAnimation(animFadeout);
            }
        }, SPLASH_SLIDEOUT);
    }

}
