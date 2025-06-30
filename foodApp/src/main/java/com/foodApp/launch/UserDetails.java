package com.foodApp.launch;

import java.util.List;
import java.util.Scanner;

import com.foodApp.DAOImpl.UserDAOImpl;
import com.foodApp.models.User;

public class UserDetails {
	
	public static void main(String[] args) {
		
	
	Scanner sc=new Scanner(System.in);
	
//	System.out.println("Enter name ");
//	String name=sc.next();
//	System.out.println("Enter username");
//	String userName=sc.next();
//	System.out.println("password");
//	String password=sc.next();
//	System.out.println("Email ");
//	String email=sc.next();
//	System.out.println("phone number");
//	long phoneNumber=sc.nextLong();
//	System.out.println("Enter Address ");
//	String address=sc.next();
//	System.out.println("Enter Role ");
//	String role=sc.next();

//		User user=new User(name,userName,password, email,phoneNumber, address, role);
//		
		UserDAOImpl impl=new UserDAOImpl();
//		impl.addUser(user);
	
//	System.out.println("Enter user id");
//	int id=sc.nextInt();
//	
//	User user=impl.getUserDetailsById(id);
//	
//	System.out.println(user);
//	
//	user.setName("king");
//	user.setPassword("king@123456789");
//	user.setAddress("jaya nagar");
//	impl.updateUserDetails(user);
		
		impl.getAllUsers().forEach(System.out::println);
		
		impl.deleteUser(5);
		
	}
}
