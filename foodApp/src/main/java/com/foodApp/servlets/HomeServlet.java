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

import com.foodApp.DAOImpl.RestaurantDAOImpl;
import com.foodApp.models.Restaurant;

@WebServlet("/restaurant")
public class HomeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" Hii from homeservlet ");
		
		RestaurantDAOImpl restaurantDAOImpl = new RestaurantDAOImpl();
		List<Restaurant> allRestaurantsDetails = restaurantDAOImpl.getAllRestaurantsDetails();
	
		for(Restaurant res: allRestaurantsDetails) {
			System.out.println(res);
		}
		
		HttpSession session=req.getSession();
		session.setAttribute("allRestaurantsDetails", allRestaurantsDetails);
		//req.setAttribute("allRestaurantsDetails", allRestaurantsDetails);
		
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
	
}
