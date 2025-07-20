package com.foodApp.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import com.foodApp.DAO.OrderDAO;
import com.foodApp.models.Order;
import com.foodApp.utility.Utility;

public class OrderDAOImpl implements OrderDAO{
	
	String insert_query="insert into `order` (restaurantid, userid, orderdate, totalamount, status, paymentmode) values(?,?,?,?,?,?)";
	@Override
	public int addOrderDetails(Order order) {
		Connection con=Utility.requestConnection();
		int orderid=0;
		try {
			PreparedStatement pstmt=con.prepareStatement(insert_query, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, order.getRestaurantid());
			pstmt.setInt(2, order.getUserid());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setDouble(4, order.getTotalamount());
			pstmt.setString(5, order.getStatus());
			pstmt.setString(6, order.getPaymentmode());
			
			int val=pstmt.executeUpdate();
			System.out.println("insertion happened successfully "+val);
			
			ResultSet res=pstmt.getGeneratedKeys();
			if(res.next()) {
				orderid=res.getInt(1);
			    System.out.println("Generated Order ID: " + orderid);
			}
			else {
			    System.out.println("Order id is not generated ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderid;
=======
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
>>>>>>> branch 'main' of https://github.com/Prasadhprasadh/foodApp_Application
		
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
