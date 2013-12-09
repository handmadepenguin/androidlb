package com.floydmobile.julianreyes;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class MenuList implements Parcelable {

	private String strValue; 
	private Integer intValue; 
	private String[] strArray;
	/**
	 *  Standard basic constructor for non-parcel
	 *  object creation */
	
	public MenuList() { ; };
	/** Constructor to use when re-constructing object 
	 * from a parcel 
	 * @param in a parcel from which to read this object */ 
	public MenuList(Parcel in) { readFromParcel(in); }   
	/** standard getter
	 *  @return strValue */ 
	public String getStrValue() { return strValue; }   
	/** Standard setter
	 *  @param strValue */ 
	public void setStrValue(String strValue) { this.strValue = strValue; }
	/**
	 *  standard getter
	 *   @return intValue*/
	public Integer getIntValue() { return intValue; }   
	/**
	 * Standard setter
	 *  @param intValue */ 
	public void setIntValue(Integer intValue) { this.intValue = intValue; } 
	
	public void setStrArray(String[] strArray) {
		this.strArray = Arrays.copyOf(strArray, strArray.length); 
		} 
	public String[] getStrArray() {
        return Arrays.copyOf(strArray, strArray.length);
    }
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		// We just need to write each field into the 
		// parcel. When we read from parcel, they
		// will come back in the same order 
		dest.writeString(strValue); 
		dest.writeInt(intValue); 
		}
	/** Called from the constructor to create this 
	 * object from a parcel. 
	 * @param in parcel from which to re-create object */
	private void readFromParcel(Parcel in) {   
		// We just need to read back each 
		// field in the order that it was 
		// written to the parcel 
		strValue = in.readString(); 
		intValue = in.readInt(); 
	}   
		/** This field is needed for Android to be able to
		 *  create new objects, individually or as arrays.
		 *  This also means that you can use use the default
		 *  constructor to create the object and use another
		 *  method to hyrdate it as necessary.
		 *  I just find it easier to use the constructor.
		 *  It makes sense for the way my brain thinks ;-) **/
	
	public static final Parcelable.Creator<MenuList> CREATOR =
			new Parcelable.Creator<MenuList>()
	{ 
		public MenuList createFromParcel(Parcel in)
			{ return new MenuList(in); }  
		public MenuList[] newArray(int size)
			{ return new MenuList[size]; } 
	};

}
