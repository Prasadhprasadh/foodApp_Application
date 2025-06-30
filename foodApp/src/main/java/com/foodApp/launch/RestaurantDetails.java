package com.foodApp.launch;

import java.util.Scanner;

import com.foodApp.DAOImpl.RestaurantDAOImpl;
import com.foodApp.models.Restaurant;

public class RestaurantDetails {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		
//	System.out.println("Enter restaurant name ");
//	String name=sc.nextLine();
//	System.out.println("Enter address of restaurant ");
//	String address=sc.nextLine();
//	System.out.println("Enter phone number of restaurant ");
//	String phoneNumber=sc.next();
//	sc.nextLine();
//	System.out.println("Enter cuisine type of restaurant ");
//	String cuisineType=sc.nextLine();
//	System.out.println("Enter admin id ");
//	int adminuserid=sc.nextInt();
//	System.out.println("Enter the rating ");
//	double rating=sc.nextDouble();
//	System.out.println("Whether restaurant is open ");
//	boolean isActive=sc.nextBoolean();
//	System.out.println("Give image path  ");
//	String imagePath=sc.next();
//	
//	Restaurant restaurant=new Restaurant(name,address,phoneNumber,cuisineType,adminuserid, rating,isActive,imagePath);
	
	RestaurantDAOImpl impl=new RestaurantDAOImpl();
	impl.deleteRestaurantById(4);
	}
}
