package com.foodApp.models;

import java.util.Date;

public class Order {

	int orderid;
	int restaurantid;
	int userid;
	Date orderdate;
	double totalamount;
	String status;
	String paymentmode;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public Order(int restaurantid, int userid,double totalamount, String status, String paymentmode) {
		super();
		this.restaurantid = restaurantid;
		this.userid = userid;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", restaurantid=" + restaurantid + ", userid=" + userid + ", orderdate="
				+ orderdate + ", totalamount=" + totalamount + ", status=" + status + ", paymentmode=" + paymentmode
				+ "]";
	}
	
	
	
}
