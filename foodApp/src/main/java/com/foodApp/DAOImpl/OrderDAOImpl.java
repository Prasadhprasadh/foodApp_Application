package com.foodApp.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.foodApp.DAO.OrderDAO;
import com.foodApp.models.Order;
import com.foodApp.utility.Utility;

public class OrderDAOImpl implements OrderDAO{
	
	String insert_query="insert into `order` (restaurantid, userid, orderdate, totalamount, status, paymentmode) values(?,?,?,?,?,?)";
	@Override
	public void addOrderDetails(Order order) {
		Connection con=Utility.requestConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(insert_query);
			
			pstmt.setInt(1, order.getRestaurantid());
			pstmt.setInt(2, order.getUserid());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setDouble(4, order.getTotalamount());
			pstmt.setString(5, order.getStatus());
			pstmt.setString(6, order.getPaymentmode());
			
			int val=pstmt.executeUpdate();
			System.out.println("insertion happened successfully "+val);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Order getOrderById(int orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderDetails(Order ordeer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderDetails(int orderid) {
		// TODO Auto-generated method stub
		
	}

}
