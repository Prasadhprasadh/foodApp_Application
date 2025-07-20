package com.foodApp.models;

public class OrderItem {

<<<<<<< HEAD
	private int orderitemid;
	private int orderid;
	private int menuid;
	private int quantity;
	private double totalamount;
=======
	int orderitemid;
	int orderid;
	int menuid;
	int quantity;
	double totalamount;
>>>>>>> branch 'main' of https://github.com/Prasadhprasadh/foodApp_Application
	
	public int getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public OrderItem(int orderid, int menuid, int quantity, double totalamount) {
		super();
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalamount = totalamount;
	}
	@Override
	public String toString() {
		return "OrderItem [orderitemid=" + orderitemid + ", orderid=" + orderid + ", menuid=" + menuid + ", quantity="
				+ quantity + ", totalamount=" + totalamount + "]";
	}
	
	
}
