package com.floydmobile.julianreyes;

public class ModelMainMenuList {
	
	private  String menuItem="";
    private  String image="";
    private  String activtyName="";
     
    /*********** Set Methods ******************/
     
    public void setMenuItem(String menuItem)
    {
        this.menuItem = menuItem;
    }
     
    public void setImage(String image)
    {
        this.image = image;
    }
     
    public void setActivityName(String activityName)
    {
        this.activtyName = activityName;
    }
     
    /*********** Get Methods ****************/
     
    public String getMenuItem()
    {
        return this.menuItem;
    }
     
    public String getImage()
    {
        return this.image;
    }
 
    public String getActivityName()
    {
        return this.activtyName;
    }    
}
