package com.androidlb.dirtywater;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

class Evaluation
{

	public String name;
	public String criterias[];
	public String layout_style;

}

public class PTResources extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                XmlPullParserFactory pullParserFactory;
		try {
			pullParserFactory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = pullParserFactory.newPullParser();

			InputStream in_s = getApplicationContext().getAssets().open("dirty_water_plist.xml");
		        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
	                parser.setInput(in_s, null);
	                parseXML(parser);

		} catch (XmlPullParserException e) {

			e.printStackTrace();
		} catch (IOException e) {
			Log.i("PTResources","Shit Happened");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
	}

        private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
	{
		ArrayList<Evaluation> evaluations = null;
                int eventType = parser.getEventType();
                Evaluation currentEvaluation = null;

                while (eventType != XmlPullParser.END_DOCUMENT){
                   String name = null;
                   switch (eventType){
                      case XmlPullParser.START_DOCUMENT:
                	 evaluations = new ArrayList<Evaluation>();
                         break;
                      case XmlPullParser.START_TAG:
                         name = parser.getName();
                         if (name.equalsIgnoreCase("eval")){
                            currentEvaluation = new Evaluation();
                         } else if (currentEvaluation != null){
                        	 //Log.i("PTResources","currEval not null");
                             if (name.equalsIgnoreCase("name")){
                                int id_name = getResources().getIdentifier(parser.nextText(), "string", "com.androidlb.dirtywater");
                                currentEvaluation.name = getResources().getString(id_name);
                            	Log.i("PTResources",getResources().getString(id_name));
                             } else if (name.equalsIgnoreCase("criterias")){
                                int id_criterias = getResources().getIdentifier(parser.nextText(), "array", "com.androidlb.dirtywater");
                                currentEvaluation.criterias = getResources().getStringArray(id_criterias);
                                Log.i("PTResources",currentEvaluation.criterias[0]);
                             } else if (name.equalsIgnoreCase("layout_style")){
                               currentEvaluation.layout_style= parser.nextText();
                             }  
                         }
                         break;
                      case XmlPullParser.END_TAG:
                         name = parser.getName();
                         if (name.equalsIgnoreCase("eval") && currentEvaluation != null){
                    	    evaluations.add(currentEvaluation);
                         } 
                   }
                   eventType = parser.next();
                   
               }

               printProducts(evaluations);
	}

        private void printProducts(ArrayList<Evaluation> evaluations)
	{
		String content = "";
		Iterator<Evaluation> it = evaluations.iterator();
		
		while(it.hasNext())
		{
			Evaluation currProduct  = it.next();
			content = content + "Evaluation Name :" +  currProduct.name + "\n";
			content = content + "Optimal:" +  currProduct.criterias[0] + "\n";
			content = content + "Suboptimal:" +  currProduct.criterias[1] + "\n";
			content = content + "Marginal:" +  currProduct.criterias[2] + "\n";
			content = content + "Poor:" +  currProduct.criterias[3] + "\n";
			content = content + "Layout Style :" +  currProduct.layout_style + "\n\n";

		}

		TextView display = (TextView)findViewById(R.id.info);
		display.setText(content);
	}

        @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}











}