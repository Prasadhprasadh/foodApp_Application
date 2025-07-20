package com.foodApp.models;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class Cart {

	private HashMap<Integer, CartItem> cartitems;
	
	public Cart() {
		cartitems=new HashMap<Integer, CartItem>();
	}
	
	public void addItemInCart(HttpServletRequest req){
		
		int itemid =Integer.parseInt(req.getParameter("menuid"));
		int quantity =Integer.parseInt(req.getParameter("quantity"));
		int restaurantid =Integer.parseInt(req.getParameter("restaurantid"));
		String name=req.getParameter("itemname");
		double price=Double.parseDouble(req.getParameter("price"));
		
		 if (cartitems.containsKey(itemid)) {
	            CartItem existing = cartitems.get(itemid);
	            existing.setQuantity(existing.getQuantity() + quantity);
	        } else {
	            CartItem newItem = new CartItem(itemid, restaurantid, name, quantity, price);
	            cartitems.put(itemid, newItem);
	        }
		 
		 for(CartItem cartitem: cartitems.values()) {
			 System.out.println(cartitem);
		 }
		 
	}
	
	public void updateItemInCart(HttpServletRequest req) {
	    int itemid = Integer.parseInt(req.getParameter("menuid"));
	    int quantity = Integer.parseInt(req.getParameter("quantity"));

	    if (cartitems.containsKey(itemid)) {
	        CartItem item = cartitems.get(itemid);
	        item.setQuantity(quantity);
	    }
	}

	public void deleteItemFromCart(HttpServletRequest req) {
	    int itemid = Integer.parseInt(req.getParameter("menuid"));
	    cartitems.remove(itemid);
	}

	public HashMap<Integer, CartItem> getCartitems() {
	    return cartitems;
	}

	public double getTotalAmount() {
	    double total = 0;
	    for (CartItem item : cartitems.values()) {
	        total += item.getPrice() * item.getQuantity();
	    }
	    return total;
	}

}
