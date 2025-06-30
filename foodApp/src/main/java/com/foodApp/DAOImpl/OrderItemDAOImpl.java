package com.foodApp.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.foodApp.DAO.OrderItemDAO;
import com.foodApp.models.OrderItem;
import com.foodApp.utility.Utility;

public class OrderItemDAOImpl implements OrderItemDAO{
	static Connection con=Utility.requestConnection();
	static PreparedStatement pstmt;

	
	final static String insert_query="insert into orderitem (orderid, menuid, quantity, totalamount) values(?,?,?,?)";
	static final String get_query="select * from orderitem where orderid=? ";
	public void addOrderItem(OrderItem orderitem) {
		try {
			pstmt = con.prepareStatement(insert_query);
			pstmt.setInt(1, orderitem.getOrderid());
			pstmt.setInt(2, orderitem.getMenuid());
			pstmt.setInt(3, orderitem.getQuantity());
			pstmt.setDouble(4, orderitem.getTotalamount());
			
			int val=pstmt.executeUpdate();
			System.out.println("Inserted value succssfully "+val);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public OrderItem getOrderItemById(int orderitemid) {
		
		return null;
	}

	@Override
	public List<OrderItem> getAllOrderItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderItem(OrderItem orderitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderItem(int orderitemid) {
		// TODO Auto-generated method stub
		
	}
}
