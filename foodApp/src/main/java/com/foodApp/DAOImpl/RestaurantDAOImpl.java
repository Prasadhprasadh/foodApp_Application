package com.foodApp.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import com.foodApp.DAO.RestaurantDAO;
import com.foodApp.models.Restaurant;
import com.foodApp.utility.Utility;
import com.mysql.cj.util.Util;

public class RestaurantDAOImpl implements RestaurantDAO{
	
	String insert_Restaurant="insert into `restaurant` (`name`, `address`,`phonenumber`,`cuisinetype`,`deliverytime`,adminUserId,`rating`,`isactive`,`imagepath`) values (?,?,?,?,?,?,?,?,?)";
	String get_query="select * from `restaurant` where restaurantid= ?";
	String delete_query="delete from `restaurant` where restaurantid= ?";
	String update_query="update restaurant set name=? ,address=?, phonenumber=?, cuisinetype=?, delivertime=?, adminUserId=?, rating=?, isactive=?, imagepath=? where restaurantid=? ";
	String getAllUsers_query="select * from restaurant";
	
	@Override
	public void addRestaurantDetails(Restaurant restaurant){	
		Connection con=Utility.requestConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt=con.prepareStatement(insert_Restaurant);
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getAddress());
			pstmt.setString(3, restaurant.getPhoneNumber());
			pstmt.setString(4, restaurant.getCuisineType());
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(6, restaurant.getAdminUserId());
			pstmt.setDouble(7, restaurant.getRating());
			pstmt.setBoolean(8, restaurant.getisActive());
			pstmt.setString(9, restaurant.getImagePath());

			
			int value=pstmt.executeUpdate();
			System.out.println("Number of rows added into table "+value);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteRestaurantById(int restaurantId) {
		Connection con=Utility.requestConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=con.prepareStatement(delete_query);
			pstmt.setInt(1, restaurantId);
			
			int val=pstmt.executeUpdate();
			System.out.println(val+" user details deleted Successfully ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) {
		Connection con=Utility.requestConnection();
		PreparedStatement pstmt=null;
		Restaurant restaurant=null;
		try {
			pstmt=con.prepareStatement(get_query);
			pstmt.setInt(1, restaurantId);
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				String name=res.getString("name");
				String address=res.getString("address");
				String phonenumber=res.getString("phonenumber");
				String cuisinetype=res.getString("cuisinetype");
				Timestamp deliverytime=res.getTimestamp("deliverytime");
				int adminuserid=res.getInt("adminUserId");
				double rating=res.getDouble("rating");
				boolean isactive=res.getBoolean("isactive");
				String imagepath=res.getString("imagepath");
				
				restaurant=new Restaurant(name, address, phonenumber, cuisinetype, adminuserid, rating, isactive, imagepath);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt !=null)pstmt.close();
				if(con !=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return restaurant;
	}

	@Override
	public void updateRestaurantDetails(Restaurant restaurant) {
		Connection con=Utility.requestConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(update_query);
			
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getAddress());
			pstmt.setString(3, restaurant.getPhoneNumber());
			pstmt.setString(4, restaurant.getCuisineType());
			pstmt.setTimestamp(5, restaurant.getDeliveryTime());
			pstmt.setInt(6, restaurant.getAdminUserId());
			pstmt.setDouble(7, restaurant.getRating());
			pstmt.setBoolean(8, restaurant.getisActive());
			pstmt.setString(9, restaurant.getImagePath());
			pstmt.setInt(10, restaurant.getRestaurantId());

			int val=pstmt.executeUpdate();
			System.out.println(val +" user details updated successfully ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurantsDetails() {
		List<Restaurant> allusers = new ArrayList<>();
		Connection con=Utility.requestConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=con.prepareStatement(getAllUsers_query);
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				int restaurantid=res.getInt("restaurantid");
				String name=res.getString("name");
				String address=res.getString("address");
				String phonenumber=res.getString("phonenumber");
				String cuisinetype=res.getString("cuisinetype");
				Timestamp deliverytime=res.getTimestamp("deliverytime");
				int adminuserid=res.getInt("adminUserId");
				double rating=res.getDouble("rating");
				boolean isactive=res.getBoolean("isactive");
				String imagepath=res.getString("imagepath");
				
				Restaurant restaurant=new Restaurant(name, address, phonenumber, cuisinetype, adminuserid, rating, isactive, imagepath);
				allusers.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allusers;
	}

}
