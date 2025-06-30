package com.foodApp.DAO;

import java.util.List;

import com.foodApp.models.OrderItem;

public interface OrderItemDAO {

	void addOrderItem(OrderItem orderitem);
	OrderItem getOrderItemById(int orderitemid);
	List<OrderItem> getAllOrderItems();
	void updateOrderItem(OrderItem orderitem);
	void deleteOrderItem(int orderitemid);
}
