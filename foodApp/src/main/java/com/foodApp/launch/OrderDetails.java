package com.foodApp.launch;

import java.util.Scanner;

import com.foodApp.DAOImpl.OrderDAOImpl;
import com.foodApp.models.Order;

public class OrderDetails {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter restaurant id ");
		int restaurantid=sc.nextInt();
		System.out.println("Enter user id ");
		int userid=sc.nextInt();
		System.out.println("Enter total amount ");
		double totalamount=sc.nextDouble();
		sc.nextLine();
		System.out.println("what is the status ");
		String status=sc.nextLine();
		System.out.println("tell me payment mode ");
		String paymentmode=sc.nextLine();
		
		Order order=new Order(restaurantid, userid, totalamount, status, paymentmode );
		
		OrderDAOImpl orderimpl=new OrderDAOImpl();
		orderimpl.addOrderDetails(order);
		
	}
}
