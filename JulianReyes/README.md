JulianReyes<br>
/***************/<br>
This is a recreation of the ios app of the same title.<br>

The androidmanifest.xml<br>
Here the app is a demonstration of ensuring the app is run only on portrait mode.<br>

CustomListViewAndroidExample.java //Activity with main content is a custome listview<br>

AdapterMainMenuList.java //Extension of a BaseAdapter that supplies the listview with custom content<br>
custom_list.xml //Layout provides listview for Activity<br>
list_item1.xml //Layout providing most of the work for customization, used by AdapterMainMenuList.java<br>

android-async-http-1.4.1.jar  //Library used to make asynchrounous requests to download JSON and binary files<br>
                              //within the activity CustomListViewAndroidExample.java<br>
                              
YouTubeAndroidPlayerApi.jar  //Library used to play youtube videos in app used by activity YouTubeAPITest.java<br>

values/values-sw600dp/values-sw720dp-land    //Folders with dimen files used to ensure main menu looks<br>
                                             //as it should on multiple devices<br>
                                             
In anim/ directory<br>
listviewlayout.xml  // An example of layout animation provides the slide up of the list view in CustomListViewAndroidExample.java<br>
slide_up.xml        // The animation that listviewlayout.xml carries out.<br>

Splashscreen animation<br>
fadepresplash.xml          //These files carry out the splashpage at the application startup<br>
splash_slide_left_out.xml<br>
splash_page.xml<br>
SplashPage.java<br>
