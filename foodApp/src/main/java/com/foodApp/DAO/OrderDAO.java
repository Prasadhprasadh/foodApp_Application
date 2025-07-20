package com.foodApp.DAO;

import java.util.List;

import com.foodApp.models.Order;

public interface OrderDAO {
	
<<<<<<< HEAD
	int addOrderDetails(Order order);
	Order getOrderById(int orderid);
	List<Order> getAllOrders();
	
=======
	void addOrderDetails(Order order);
	Order getOrderById(int orderid);
	List<Order> getAllOrders();
>>>>>>> branch 'main' of https://github.com/Prasadhprasadh/foodApp_Application
	void updateOrderDetails(Order ordeer);
	void deleteOrderDetails(int orderid);
}
