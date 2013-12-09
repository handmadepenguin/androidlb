package com.floydmobile.julianreyes;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
public class YouTubeAPITest extends YouTubeBaseActivity implements
YouTubePlayer.OnInitializedListener, YouTubePlayer.OnFullscreenListener {

	private LinearLayout baseLayout;
	private YouTubePlayerView playerView;
	private boolean fullscreen;
	//private View otherViews;
static private final String DEVELOPER_KEY = "AIzaSyD-CVAAeZc_XTKfUt-fGJ9n-zvJOy83DzQ";
      
	   static private String VIDEO = null;
       @Override
       protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.you_tube_apitest);
              //Bundle b = this.getIntent().getExtras();
              VIDEO = this.getIntent().getStringExtra("video");
              playerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
              //otherViews = findViewById(R.id.other_views);
              playerView.initialize(DEVELOPER_KEY, this);
          }
         @Override
         public void onInitializationFailure(Provider provider,
YouTubeInitializationResult error) {
                Toast.makeText(this, "Oh no! "+error.toString(),
Toast.LENGTH_LONG).show();
       }
       @Override
       public void onInitializationSuccess(Provider provider, YouTubePlayer player,
boolean wasRestored) {
    	// Specify that we want to handle fullscreen behavior ourselves.
    	    //player.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CUSTOM_LAYOUT);
    	    //player.setOnFullscreenListener((OnFullscreenListener) this);
    	    //player.setFullscreen(true);
    	    player.loadVideo(VIDEO);
    	    
       }
       
       private void doLayout(){
    	   LinearLayout.LayoutParams playerParams =
    		        (LinearLayout.LayoutParams) playerView.getLayoutParams();
    	   if (fullscreen) {
    		      // When in fullscreen, the visibility of all other views than the player should be set to
    		      // GONE and the player should be laid out across the whole screen.
    		      playerParams.width = LayoutParams.MATCH_PARENT;
    		      playerParams.height = LayoutParams.MATCH_PARENT;

    		      //otherViews.setVisibility(View.GONE);
    		    } else {
    		      // This layout is up to you - this is just a simple example (vertically stacked boxes in
    		      // portrait, horizontally stacked in landscape).
    		      //otherViews.setVisibility(View.VISIBLE);
    		      //ViewGroup.LayoutParams otherViewsParams = otherViews.getLayoutParams();
    		      if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		        //playerParams.width = otherViewsParams.width = 0;
    		        playerParams.height = WRAP_CONTENT;
    		        //otherViewsParams.height = MATCH_PARENT;
    		        playerParams.weight = 1;
    		        baseLayout.setOrientation(LinearLayout.HORIZONTAL);
    		      } else {
    		        //playerParams.width = otherViewsParams.width = MATCH_PARENT;
    		        playerParams.height = WRAP_CONTENT;
    		        playerParams.weight = 0;
    		        //otherViewsParams.height = 0;
    		        baseLayout.setOrientation(LinearLayout.VERTICAL);
    		      }
    		      //setControlsEnabled();
    		    }
       }
       
	@Override
	public void onFullscreen(boolean isFullscreen) {
		// TODO Auto-generated method stub
		doLayout();
	}
}
