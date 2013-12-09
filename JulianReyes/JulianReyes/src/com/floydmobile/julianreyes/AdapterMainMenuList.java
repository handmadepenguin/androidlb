package com.floydmobile.julianreyes;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterMainMenuList extends BaseAdapter implements OnClickListener {

	/*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList<ModelMainMenuList> data;
    private static LayoutInflater inflater=null;
    public Resources res;
    ModelMainMenuList tempValues=null;
    int i=0;
	
    /*************  CustomAdapter Constructor *****************/
    public AdapterMainMenuList(Activity a, ArrayList<ModelMainMenuList> d,Resources resLocal) {
         
           /********** Take passed values **********/
            activity = a;
            data=d;
            res = resLocal;
         
            /***********  Layout inflator to call external xml layout () ***********/
             inflater = ( LayoutInflater )activity.
                                         getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         
    }
    
	@Override
	public int getCount() {
		if(data.size()<=0)
            return 1;
        return data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	/********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{
         
        public TextView text;
        public ImageView image;
 
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
        ViewHolder holder;
         
        if(convertView==null){
             
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.tabitem, null);
             
            /****** View Holder Object to contain tabitem.xml file elements ******/
           
            holder = new ViewHolder();
            holder.text = (TextView) vi.findViewById(R.id.activityName);
            holder.image=(ImageView)vi.findViewById(R.id.imageView1);
            
             
           /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else 
            holder=(ViewHolder)vi.getTag();
         
        if(data.size()<=0)
        {
            holder.text.setText("No Data");
             
        }
        else
        {
            /***** Get each Model object from ArrayList ********/
            tempValues=null;
            tempValues = ( ModelMainMenuList ) data.get( position );
             
            /************  Set Model values in Holder elements ***********/
            //Log.e(AdapterMainMenuList.class.toString(), tempValues.getImage());
             holder.text.setText( tempValues.getActivityName() );
            
              holder.image.setImageResource(R.drawable.charity);
              int drawableId = res.getIdentifier(tempValues.getImage(), "drawable", "com.floydmobile.julianreyes");
              holder.image.setImageResource(drawableId);
             /*
             int drawableId = 0;
             try {
            	    Class res = R.drawable.class;
            	    Field field = res.getField(tempValues.getImage());
            	    drawableId = field.getInt(null);
            	    holder.image.setImageResource(drawableId);
            	}
            	catch (Exception e) {
            	    Log.e("MyTag", "Failure to get drawable id.", e);
            	}
             */
             
             /******** Set Item Click Listener for LayoutInflater for each row *******/

             vi.setOnClickListener(new OnItemClickListener( position ));
        }
        return vi;
	}

	@Override
	public void onClick(View arg0) {
		Log.v("CustomAdapter", "=====Row button clicked=====");
		
	}

	/********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements OnClickListener{           
        private int mPosition;
         
        OnItemClickListener(int position){
             mPosition = position;
        }
         
        @Override
        public void onClick(View arg0) {

  
          CustomListViewAndroidExample sct = (CustomListViewAndroidExample)activity;

         /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/

            sct.onItemClick(mPosition);
           
        }    
       
    }   
}
