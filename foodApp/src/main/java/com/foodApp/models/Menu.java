package com.foodApp.models;

public class Menu {

	int menuid;
	int restaurantid;
	String itemname;
	String description;
	double price;
	boolean isavailable;
	double rating;
	String imagepath;
	
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isIsavailable() {
		return isavailable;
	}
	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public Menu(int restaurantid, String itemname, String description, double price, boolean isavailable,
			double rating, String imagepath) {
		super();
		this.restaurantid=restaurantid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isavailable = isavailable;
		this.rating = rating;
		this.imagepath = imagepath;
	}
	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", restaurantid=" + restaurantid + ", itemname=" + itemname + ", description="
				+ description + ", price=" + price + ", isavailable=" + isavailable + ", rating=" + rating
				+ ", imagepath=" + imagepath + "]";
	}
	
	
}
