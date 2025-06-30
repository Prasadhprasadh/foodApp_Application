package com.foodApp.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.DAO.UserDAO;
import com.foodApp.models.User;
import com.foodApp.utility.Utility;

public class UserDAOImpl implements UserDAO{

	public static Connection con=null;

	String insertQuery="insert into `user` (`name`, `username`, `password`, `email`, `phonenumber`, `address`, `role`, `create_date`, `last_login_date` ) values(?,?,?,?,?,?,?,?,?)";
	String get_query="select * from `user` where userid= ?";
	String update_query="update `user` set name=?,username=?, password=?, email=?, phonenumber=?, address=?, role=?  where userid=?";
	String getallusers_query="select * from `user`";
	String delete_query="delete from `user` where userid=?";
	@Override
	public void addUser(User user){
		try {
			con=Utility.requestConnection();
			PreparedStatement stmt=con.prepareStatement(insertQuery);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setLong(5, user.getPhoneNumber());
			stmt.setString(6, user.getAddress());
			stmt.setString(7, user.getRole());
			stmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			stmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			
			int value=stmt.executeUpdate();
			
			System.out.println(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUserDetailsById(int userid) {
		User user=null;
		try {
			con=Utility.requestConnection();
			PreparedStatement pstmt=con.prepareStatement(get_query);
			pstmt.setInt(1, userid);
			
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				String name=res.getString("name");
				String username=res.getString("username");
				String password=res.getString("password");
				String email=res.getString("email");
				long phonenumber=res.getLong("phonenumber");
				String address=res.getString("address");
				String role=res.getString("role");
				user.setUserId(userid);
				user=new User(name, username, password, email,phonenumber,address,role);
				//System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public void deleteUser(int userId) {
		con=Utility.requestConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(delete_query);
			pstmt.setInt(1, userId);
			
			int val=pstmt.executeUpdate();
			System.out.println("deleted data successfully "+val);;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateUserDetails(User user) {
			con=Utility.requestConnection();
			try {
				PreparedStatement pstmt=con.prepareStatement(update_query);
				pstmt.setString(1,user.getName());
				pstmt.setString(2,user.getUserName());
				pstmt.setString(3,user.getPassword());
				pstmt.setString(4,user.getEmail());
				pstmt.setLong(5,user.getPhoneNumber());
				pstmt.setString(6,user.getAddress());
				pstmt.setString(7,user.getRole());
				pstmt.setInt(8, user.getUserId());
				
				int val=pstmt.executeUpdate();
				System.out.println("updated user details sucessfully "+val);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users=new ArrayList<>();
		User user=null;
		try {
			con=Utility.requestConnection();
			PreparedStatement pstmt=con.prepareStatement(getallusers_query);
			
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				String name=res.getString("name");
				String username=res.getString("username");
				String password=res.getString("password");
				String email=res.getString("email");
				long phonenumber=res.getLong("phonenumber");
				String address=res.getString("address");
				String role=res.getString("role");
				int userid=res.getInt("userid");
				user.setUserId(userid);
				user=new User(name, username, password, email,phonenumber,address,role);
				users.add(user);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	
	public boolean checkEmailExists(String email) {
		boolean exists=false;
		String getquery=" select count(*) from user where email= ?";
		
		try(Connection con=Utility.requestConnection();
				PreparedStatement pstmt=con.prepareStatement(getquery);
				){
			pstmt.setString(1, email);
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				if(res.getInt(1)>0) {
					exists=true;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return exists;
	}
}
