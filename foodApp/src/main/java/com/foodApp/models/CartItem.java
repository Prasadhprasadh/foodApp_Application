package com.foodApp.models;

public class CartItem {

	private int itemid;
	private int restaurantid;
	private String name;
	private int quantity;
	private double price;
	
	public CartItem(int itemid, int restaurantid, String name, int quantity, double price) {
		this.itemid = itemid;
		this.restaurantid = restaurantid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [itemid=" + itemid + ", restaurantid=" + restaurantid + ", name=" + name + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	public double gettotalPrice() {
		return price * quantity;
	}
	
}
