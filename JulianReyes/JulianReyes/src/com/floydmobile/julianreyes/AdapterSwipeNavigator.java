package com.floydmobile.julianreyes;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdapterSwipeNavigator extends PagerAdapter {
	CharSequence pageData[];
	private static LayoutInflater inflater=null;
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
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
