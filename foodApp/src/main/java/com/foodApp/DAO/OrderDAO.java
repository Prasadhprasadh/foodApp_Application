package com.foodApp.DAO;

import java.util.List;

import com.foodApp.models.Order;

public interface OrderDAO {
	
	void addOrderDetails(Order order);
	Order getOrderById(int orderid);
	List<Order> getAllOrders();
	void updateOrderDetails(Order ordeer);
	void deleteOrderDetails(int orderid);
}
