JulianReyes
/***************/
This is a recreation of the ios app of the same title.

The androidmanifest.xml
Here the app is a demonstration of ensuring the app is run only on portrait mode.

CustomListViewAndroidExample.java //Activity with main content is a custome listview

AdapterMainMenuList.java //Extension of a BaseAdapter that supplies the listview with custom content
custom_list.xml //Layout provides listview for Activity
list_item1.xml //Layout providing most of the work for customization, used by AdapterMainMenuList.java

android-async-http-1.4.1.jar  //Library used to make asynchrounous requests to download JSON and binary files
                              //within the activity CustomListViewAndroidExample.java
                              
YouTubeAndroidPlayerApi.jar  //Library used to play youtube videos in app used by activity YouTubeAPITest.java

values/values-sw600dp/values-sw720dp-land    //Folders with dimen files used to ensure main menu looks
                                             //as it should on multiple devices
                                             
In anim/ directory
listviewlayout.xml  // An example of layout animation provides the slide up of the list view in CustomListViewAndroidExample.java
slide_up.xml        // The animation that listviewlayout.xml carries out.

Splashscreen animation
fadepresplash.xml          //These files carry out the splashpage at the application startup
splash_slide_left_out.xml
splash_page.xml
SplashPage.java
