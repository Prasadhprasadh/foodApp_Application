package com.foodApp.launch;

import java.util.Scanner;

import com.foodApp.DAO.OrderItemDAO;
import com.foodApp.DAOImpl.OrderItemDAOImpl;
import com.foodApp.models.OrderItem;

public class OrderItemDetails {

	public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Eneter order id ");
	int orderid=sc.nextInt();
	System.out.println("enter menu id ");
	int menuid=sc.nextInt();
	System.out.println("enter quantity ");
	int quantity=sc.nextInt();
	System.out.println("Enter total amount ");
	double totalamount=sc.nextDouble();
	
	OrderItem orderitem=new OrderItem(orderid, menuid, quantity, totalamount);
	
	OrderItemDAO orderitemimpl=new OrderItemDAOImpl();
	orderitemimpl.addOrderItem(orderitem);
	
	}
	
}
