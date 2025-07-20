package com.foodApp.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.DAO.OrderDAO;
import com.foodApp.DAO.OrderItemDAO;
import com.foodApp.DAOImpl.OrderDAOImpl;
import com.foodApp.DAOImpl.OrderItemDAOImpl;
import com.foodApp.models.Cart;
import com.foodApp.models.CartItem;
import com.foodApp.models.Order;
import com.foodApp.models.OrderItem;
import com.foodApp.models.User;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

	OrderDAO orderimpl=new OrderDAOImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		User user=(User) session.getAttribute("user");
		//System.out.println(user.getUserId()+" check out page ");
		
		System.out.println("Session id is "+session.getId());

		if(user==null) {
			
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		}
		
		//System.out.println(user.getUserId()+" check out page ");

		if(user!=null && !cart.getCartitems().isEmpty()) {
			
			String paymentMode = req.getParameter("paymentMode");
			String address = req.getParameter("address");
			
			Order order=new Order();
			order.setUserid(user.getUserId());
			System.out.println("USer USer id is "+user.getUserId());
			order.setRestaurantid((int) session.getAttribute("restaurantid"));
			order.setPaymentmode(paymentMode);
			//order.setOrderdate(new Timestamp(new Date().getTime()));
			
			order.setOrderdate(new Timestamp(System.currentTimeMillis()));
			order.setStatus("Pending");
			
			// Calculate total amount
			double totalAmount=0;
			for(CartItem item: cart.getCartitems().values()) {
				totalAmount += item.getPrice() * item.getQuantity();
			}
			
			order.setTotalamount(totalAmount);
			
			int orderid=orderimpl.addOrderDetails(order);
			order.setOrderid(orderid);
			
			System.out.println("Order id is "+orderid);
			for(CartItem item: cart.getCartitems().values()) {
				
				int itemid=item.getItemid();
				int quantity=item.getQuantity();
				double totalprice=item.getPrice();
				
				OrderItem orderitem=new OrderItem(orderid, itemid, quantity, totalAmount);
				
				OrderItemDAO orderitemimpl=new OrderItemDAOImpl();
				orderitemimpl.addOrderItem(orderitem);
				
			}
			
			
			session.removeAttribute("cart");  // clear cart
			session.setAttribute("order", order);
			
			resp.sendRedirect("orderconfirm.jsp");
		}
		else {
			resp.sendRedirect("cart.jsp");
		}
	}
}
