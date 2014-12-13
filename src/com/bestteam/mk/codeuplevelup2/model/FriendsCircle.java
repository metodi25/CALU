package com.bestteam.mk.codeuplevelup2.model;

import android.graphics.Bitmap;

public class FriendsCircle {
	
	String name;
	RoundedImage image;
	Bitmap bitmapImage;
	public FriendsCircle() {
		// TODO Auto-generated constructor stub
	}

	public FriendsCircle(String namestr, Bitmap bitmapimg) {
		this.name = name;
		this.bitmapImage=bitmapimg;
		
	}
	
	public RoundedImage getImage() {
		image = new RoundedImage(this.bitmapImage);
		return image;
	}
	public void setImage(RoundedImage image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bitmap getBitmapImage() {
		return bitmapImage;
	}
	public void setBitmapImage(Bitmap bitmapImage) {
		this.bitmapImage = bitmapImage;
	}
	
	
	
}
