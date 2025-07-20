package com.foodApp.servlets;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.models.Cart;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
	Integer oldrestaurantid = (Integer)session.getAttribute("restaurantid");
	
	Integer newrestaurantid=Integer.parseInt(req.getParameter("restaurantid"));
	System.out.println("New Restaurant id  "+newrestaurantid);
	
	if(cart==null || oldrestaurantid==null || oldrestaurantid != newrestaurantid) {
		 cart=new Cart();
		session.setAttribute("cart", cart);
		session.setAttribute("restaurantid", newrestaurantid);
	}
	
	if(req.getParameter("action").equals("add")) {
		
		cart.addItemInCart(req);
	}
	else if(req.getParameter("action").equals("update")) {
		
		cart.updateItemInCart(req);
	}
	else if(req.getParameter("action").equals("delete")) {
		
		cart.deleteItemFromCart(req);
	}
	
	resp.sendRedirect("cart.jsp");
	
	}

	
	
}
