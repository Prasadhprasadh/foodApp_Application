package com.foodApp.launch;

import java.util.Scanner;

import com.foodApp.DAOImpl.MenuDAOImpl;
import com.foodApp.models.Menu;

public class MenuDetails {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter restaurant id ");
	int restaurantid=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter item name ");
	//int menuid;
	//int restaurantid;
	String itemname=sc.nextLine();
	System.out.println("Enter item description ");
	String description=sc.nextLine();
	System.out.println("Enter price ");
	double price=sc.nextDouble();
	System.out.println("whether is available ");
	boolean isavailable=sc.nextBoolean();
	System.out.println("Enter the rating ");
	double rating=sc.nextDouble();
	sc.nextLine();
	System.out.println("enter the image url ");
	String imagepath=sc.nextLine();
	
	Menu menu=new Menu(restaurantid,itemname, description, price, isavailable, rating, imagepath);
	
	MenuDAOImpl menuimpl=new MenuDAOImpl();
	menuimpl.addItemintoMenu(menu);
	
	
}
}
