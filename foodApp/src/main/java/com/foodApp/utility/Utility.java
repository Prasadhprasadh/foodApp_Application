package com.foodApp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {

	static Connection con=null;
	static String url="jdbc:mysql://localhost:3306/foodApp";
	static String user="root";
	static String password="king";
	
	static public Connection requestConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
