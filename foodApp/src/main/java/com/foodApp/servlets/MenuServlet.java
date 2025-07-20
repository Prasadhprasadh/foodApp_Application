package com.foodApp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodApp.DAOImpl.MenuDAOImpl;
import com.foodApp.models.Menu;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("\n Hii menu page ");
		int restid = Integer.parseInt(req.getParameter("restaurantId"));

		MenuDAOImpl menuDAOImpl = new MenuDAOImpl();
		List<Menu> menudetails = menuDAOImpl.getAllMenusByRestaurantId(restid);

		for (Menu menu : menudetails) {
			System.out.println(menu);
		}
		req.setAttribute("getallmenus", menudetails);
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
		
	}
}
