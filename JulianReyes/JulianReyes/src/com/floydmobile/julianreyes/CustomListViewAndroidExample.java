package com.floydmobile.julianreyes;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;


public class CustomListViewAndroidExample extends Activity {
	ListView list;
    AdapterMainMenuList adapter;
    public  CustomListViewAndroidExample CustomListView = null;
    public  ArrayList<ModelMainMenuList> CustomListViewValuesArr = new ArrayList<ModelMainMenuList>();
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list);
         
        CustomListView = this;
         
        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setListData();
         
        Resources res =getResources();
        list = ( ListView )findViewById( R.id.listView1 );  // List defined in XML ( See Below )
         
        /**************** Create Custom Adapter *********/
        adapter=new AdapterMainMenuList( CustomListView, CustomListViewValuesArr,res );
        list.setAdapter( adapter );
         
    }
 
    /****** Function to set data in ArrayList *************/
    public void setListData()
    {
         String[] menuChoices = getResources().getStringArray(R.array.tut_titles);
         String[] menuImages = getResources().getStringArray(R.array.main_menu_images);
        for (int i = 0; i < menuChoices.length; i++) {
             
            final ModelMainMenuList sched = new ModelMainMenuList();
                 
              /******* Firstly take data in model object ******/
               sched.setActivityName(""+menuChoices[i].toString());
               sched.setImage(""+menuImages[i].toString());
               sched.setMenuItem("http:\\www."+i+".com");
                
            /******** Take Model Object in ArrayList **********/
            CustomListViewValuesArr.add( sched );
        }
         
    }
    

   /*****************  This function used by adapter ****************/
    /*
    public void onItemClick(int mPosition)
    {
        ModelMainMenuList tempValues = ( ModelMainMenuList ) CustomListViewValuesArr.get(mPosition);


       // SHOW ALERT                  

        Toast.makeText(CustomListView,
                ""+tempValues.getActivityName()
                  +" Image:"+tempValues.getImage()
                  +" Url:"+tempValues.getMenuItem(),
                Toast.LENGTH_LONG).show();
    }
    */
    public void onItemClick(int position) {
		if (position == 0) {
			Intent swipeNavigator = new Intent(getApplicationContext(),
					SwipeNavigator.class);
			startActivity(swipeNavigator);
		}else if (position == 1){
			AsyncHttpClient client = new AsyncHttpClient();
			client.get("http://www.floydmobile.com/julianreyes/jrvideolog.php", new JsonHttpResponseHandler() {
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
						
						e.printStackTrace();
					}
			    }
				});
			
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
						
						e.printStackTrace();
					}
			    }
			});
		}
		else
		{
		;
		}
	}
}
