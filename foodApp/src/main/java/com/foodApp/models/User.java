package com.foodApp.models;

import java.sql.Timestamp;
import java.util.Date;

public class User {
	
<<<<<<< HEAD
	private int userId;
	private String name;
	private String userName;
	private String password;
	private String email;
	private long phoneNumber;
	private String address;
	private String role;
	private Timestamp create_date;
	private Timestamp last_login_date;
=======
	int userId;
	String name;
	String userName;
	String password;
	String email;
	long phoneNumber;
	String address;
	String role;
	Timestamp create_date;
	Timestamp last_login_date;
>>>>>>> branch 'main' of https://github.com/Prasadhprasadh/foodApp_Application
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Timestamp getLast_login_date() {
		return last_login_date;
	}
	public void setLast_login_date(Timestamp last_login_date) {
		this.last_login_date = last_login_date;
	}
	
	public User(String name, String userName, String password, String email, long phoneNumber,
			String address, String role) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", role=" + role
				+ ", createDate=" + create_date + ", lastLoginDate=" + last_login_date + "]";
	}
	
	
	
}
