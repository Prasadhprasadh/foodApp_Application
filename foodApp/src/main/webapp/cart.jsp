<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodApp.models.*, java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f0f0f0;
        }

        h1 {
            text-align: center;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: white;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ccc;
            text-align: center;
        }

        .total, .pay-section {
            font-weight: bold;
            text-align: center;
            margin-top: 20px;
        }

        .btn {
            padding: 10px 16px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        .btn:hover {
            background-color: #218838;
        }

        .action-btn {
            padding: 5px 10px;
            font-size: 14px;
            margin: 2px;
        }
    </style>
</head>
<body>

<h1>Your Cart</h1>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    Integer restaurantId = (Integer) session.getAttribute("restaurantid");

    if (cart != null && !cart.getCartitems().isEmpty()) {
        HashMap<Integer, CartItem> items = cart.getCartitems();

%>
    
    
<div style="text-align: center;">
    <a class="btn" href="menu?restaurantId=<%= restaurantId %>">+ Add Another Item</a>
</div>

<table>
    <tr>
        <th>Item</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total</th>
        <th>Actions</th>
    </tr>

    <%
        for (CartItem item : items.values()) {
    %>
    <tr>
        <td><%= item.getName() %></td>
        <td>
            <form action="cart" method="post" style="display:inline;">
                <input type="hidden" name="menuid" value="<%= item.getItemid() %>">
                <input type="hidden" name="restaurantid" value="<%= item.getRestaurantid() %>">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                <input class="action-btn" type="submit" value="−" <% if (item.getQuantity() <= 1) { %> disabled <% } %> >
            </form>
            <span><%= item.getQuantity() %></span>
            <form action="cart" method="post" style="display:inline;">
                <input type="hidden" name="menuid" value="<%= item.getItemid() %>">
                <input type="hidden" name="restaurantid" value="<%= item.getRestaurantid() %>">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                <input class="action-btn" type="submit" value="+">
            </form>
        </td>
        <td>₹<%= item.getPrice() %></td>
        <td>₹<%= item.getPrice() * item.getQuantity() %></td>
        <td>
            <form action="cart" method="post">
                <input type="hidden" name="menuid" value="<%= item.getItemid() %>">
                <input type="hidden" name="restaurantid" value="<%= item.getRestaurantid() %>">
                <input type="hidden" name="action" value="delete">
                <input class="action-btn" type="submit" value="Delete">
            </form>
        </td>
    </tr>
    <% } %>
    <tr>
        <td colspan="3" class="total">Total Amount</td>
        <td colspan="2" class="total">₹<%= cart.getTotalAmount() %></td>
    </tr>
</table>

<div class="pay-section">
    <form action="checkout.jsp" method="post">
        <input class="btn" type="submit" value="Proceed to Checkout">
    </form>
</div>

<%  
    }  else {
    	System.out.println("cart page  "+session.getAttribute("restaurantid"));
%>
        <p style="text-align: center;">Your cart is empty.</p>
        <div style="text-align: center;">
        	<a class="btn" href="menu?restaurantId=<%= session.getAttribute("restaurantid") %>">Add Items</a>
        </div>
<%} %>
    

</body>
</html>
