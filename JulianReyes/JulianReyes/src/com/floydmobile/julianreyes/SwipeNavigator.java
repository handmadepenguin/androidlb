package com.floydmobile.julianreyes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SwipeNavigator extends Activity {
	
	String pageData[];
	LayoutInflater inflater;    //Used to create individual pages
	ViewPager vp;    //Reference to class to swipe views
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_navigator);
        pageData=getResources().getStringArray(R.array.about_julian_content);
      //get an inflater to be used to create single pages
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Reference ViewPager defined in activity
        vp=(ViewPager)findViewById(R.id.viewPager);
        //set the adapter that will create the individual pages
        vp.setAdapter(new AdapterSwipeNavigator());
    }

 class AdapterSwipeNavigator extends PagerAdapter {
	
	@Override
	public int getCount() {
		return pageData.length;
	}
	
	//Create the given page (indicated by position)
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View page = inflater.inflate(R.layout.page, null);
        ((TextView)page.findViewById(R.id.textMessage)).setText(pageData[position]);
        //Add the page to the front of the queue
        ((ViewPager) container).addView(page, 0);
        return page;
    }

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		//See if object from instantiateItem is related to the given view
        //required by API
        return arg0==(View)arg1;
	}
	
	@Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      ((ViewPager) container).removeView((View) object);
      object=null;
    }

 }
}

