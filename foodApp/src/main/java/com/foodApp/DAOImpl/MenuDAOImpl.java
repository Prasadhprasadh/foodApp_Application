package com.foodApp.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.DAO.MenuDAO;
import com.foodApp.models.Menu;
import com.foodApp.utility.Utility;

/*
 * String itemname;
	String description;
	double price;
	boolean isavailable;
	double rating;
	String imagepath;
 */
public class MenuDAOImpl implements MenuDAO{

	String insert_query="insert into `menu` (restaurantid,itemname , description, price, isavailable, ratings, imagepath ) values(?,?,?,?,?,?,?)";
	String get_query="select * from menu where menuid=? ";
	String update_query="update menu set restaurantid=? ,itemname=? , description=?, price=?, isavailable=?, ratings=?, imagepath=? where menuid=?";
	String delete_query="delete from menu where menuid=?";
	String getallmenusbyrestaurantid="select * from menu where restaurantid=?";
	
	public List<Menu> getAllMenusByRestaurantId(int restaurantid){
		Connection con=Utility.requestConnection();
		List<Menu> allmenusbyrestaurantid=new ArrayList<>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(getallmenusbyrestaurantid);
			pstmt.setInt(1, restaurantid);
			//Statement st= con.createStatement();
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				
				int restaurantid1=res.getInt("restaurantid");
				String itemname=res.getString("itemname");
				String description=res.getString("description");
				double price=res.getDouble("price");
				boolean isavilable=res.getBoolean("isavailable");
				double rating=res.getDouble("ratings");
				String imagepath=res.getString("imagepath");
				int menuid=res.getInt("menuid");
				
				Menu m1=new Menu(restaurantid1, itemname, description, price, isavilable, rating, imagepath);
				m1.setMenuid(menuid);
				allmenusbyrestaurantid.add(m1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allmenusbyrestaurantid;
	}
=======
import java.util.ArrayList;
import java.util.List;

import com.foodApp.DAO.MenuDAO;
import com.foodApp.models.Menu;
import com.foodApp.utility.Utility;

/*
 * String itemname;
	String description;
	double price;
	boolean isavailable;
	double rating;
	String imagepath;
 */
public class MenuDAOImpl implements MenuDAO{

	String insert_query="insert into `menu` (restaurantid,itemname , description, price, isavailable, ratings, imagepath ) values(?,?,?,?,?,?,?)";
	String get_query="select * from menu where menuid=? ";
	String update_query="update menu set restaurantid=? ,itemname=? , description=?, price=?, isavailable=?, ratings=?, imagepath=? where menuid=?";
	String delete_query="delete from menu where menuid=?";
>>>>>>> branch 'main' of https://github.com/Prasadhprasadh/foodApp_Application
	
	@Override
	public void addItemintoMenu(Menu menu) {
		
		Connection con=Utility.requestConnection();
		try {
			PreparedStatement psmt=con.prepareStatement(insert_query);
			psmt.setInt(1, menu.getRestaurantid());
			psmt.setString(2, menu.getItemname());
			psmt.setString(3, menu.getDescription());
			psmt.setDouble(4, menu.getPrice());
			psmt.setBoolean(5, menu.isIsavailable());
			psmt.setDouble(6, menu.getRating());
			psmt.setString(7, menu.getImagepath());
			
			int val=psmt.executeUpdate();
			System.out.println("inserted values successfully "+val);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Menu getmenuById(int menuid) {
		
		try(	Connection con = Utility.requestConnection();
				PreparedStatement pstmt = con.prepareStatement(get_query);
				)
		{
			pstmt.setInt(1, menuid);
			ResultSet res = pstmt.executeQuery();

			if(res.next()) {
				
				int restaurantid=res.getInt("restaurantid");
				String itemname=res.getString("itemname");
				String description=res.getString("description");
				double price=res.getDouble("price");
				boolean isavilable=res.getBoolean("isavailable");
				double rating=res.getDouble("ratings");
				String imagepath=res.getString("imagepath");
				int id=res.getInt("menuid");
				
				Menu m1=new Menu(restaurantid, itemname, description, price, isavilable, rating, imagepath);
				m1.setMenuid(id);
				return m1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Menu> getAllMenu() {
		List<Menu> allmenus=new ArrayList<>();
		
		try(	Connection con = Utility.requestConnection();
				PreparedStatement pstmt=con.prepareStatement("select * from menu"); ) {
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()){
				
				int restaurantid=res.getInt("restaurantid");
				String itemname=res.getString("itemname");
				String description=res.getString("description");
				double price=res.getDouble("price");
				boolean isavilable=res.getBoolean("isavailable");
				double rating=res.getDouble("ratings");
				String imagepath=res.getString("imagepath");
				int id=res.getInt("menuid");
				
				Menu m1=new Menu(restaurantid, itemname, description, price, isavilable, rating, imagepath);
				m1.setMenuid(id);
				allmenus.add(m1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allmenus;
	}
	
	@Override
	public void updateMenu(Menu menu) {
		 try (Connection con = Utility.requestConnection();
		         PreparedStatement pstmt = con.prepareStatement(update_query)) {
		        
		        pstmt.setInt(1, menu.getRestaurantid());
		        pstmt.setString(2, menu.getItemname());
		        pstmt.setString(3, menu.getDescription());
		        pstmt.setDouble(4, menu.getPrice());
		        pstmt.setBoolean(5, menu.isIsavailable());
		        pstmt.setDouble(6, menu.getRating());
		        pstmt.setString(7, menu.getImagepath());
		        pstmt.setInt(8, menu.getMenuid()); // WHERE clause parameter

		        int rowsUpdated = pstmt.executeUpdate();
		        if (rowsUpdated > 0) {
		            System.out.println("Menu updated successfully.");
		        } else {
		            System.out.println("Menu not found.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}

	@Override
	public void deleteMenuById(int id) {
		
		 try (Connection con = Utility.requestConnection();
		         PreparedStatement pstmt = con.prepareStatement(delete_query)) {
		        
		        pstmt.setInt(1, id);

		        int rowsDeleted = pstmt.executeUpdate();
		        if (rowsDeleted > 0) {
		            System.out.println("Menu deleted successfully.");
		        } else {
		            System.out.println("Menu ID not found.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

}
