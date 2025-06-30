package com.foodApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodApp.DAOImpl.UserDAOImpl;
import com.foodApp.models.User;


@WebServlet("/Register")
public class Register extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name=req.getParameter("name");
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String val=req.getParameter("phonenumber");
		long phoneNumber=Long.parseLong(val);
		String address=req.getParameter("address");
		String role=req.getParameter("role");
		
		User u1=new User(name, userName, password, email, phoneNumber, address, role);
		
		UserDAOImpl userimpl=new UserDAOImpl();
		PrintWriter writer = resp.getWriter();
		
		
		if(userimpl.checkEmailExists(u1.getEmail())) {
			writer.print("User with email already registered ");
		}
		else {
			userimpl.addUser(u1);
			writer.print("Hii"+ u1.getName()+" registered successfully ");
		}
		
		
	}
}
