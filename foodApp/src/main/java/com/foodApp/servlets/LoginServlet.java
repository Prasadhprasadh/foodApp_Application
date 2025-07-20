package com.foodApp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.DAO.RestaurantDAO;
import com.foodApp.DAO.UserDAO;
import com.foodApp.DAOImpl.RestaurantDAOImpl;
import com.foodApp.DAOImpl.UserDAOImpl;
import com.foodApp.models.Restaurant;
import com.foodApp.models.User;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		System.out.println("Email is "+email+" Password is "+password);
		
		HttpSession session=req.getSession();
		System.out.println("Session id is %%%%%%%%%%%%%%%%%%%"+session.getId());
		RequestDispatcher rd;
		
		UserDAO userdao = new UserDAOImpl();
		User user=userdao.getUserDetailsByEmail(email);
        //System.out.println(user.getUserId()+"login servlet%%%%%%%%%%%% ");
		//System.out.println(user.toString()+"useruuuuuuuuuuuu ");

		if(user!=null && user.getPassword().equals(password)) {
			session.setAttribute("user", user);
			
			RestaurantDAO restaurantDao = new RestaurantDAOImpl();
            List<Restaurant> allRestaurants = restaurantDao.getAllRestaurantsDetails(); // Your method to get list
            req.setAttribute("allRestaurantsDetails", allRestaurants);
            System.out.println(user.getUserId()+"login servlet ");
            
			rd=req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
			
			

		}
		else {
			rd=req.getRequestDispatcher("register.html");
			rd.forward(req, resp);
		}
	}
	
}
