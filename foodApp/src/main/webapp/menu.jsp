
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodApp.models.Menu,java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Restaurant Menu | FoodieApp</title>
  <style>
    * {
      box-sizing: border-box;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      margin: 0;
      padding: 0;
    }

    body {
      background-color: #f8f8f8;
      padding: 20px;
    }

    .restaurant-header {
      text-align: center;
      margin-bottom: 30px;
    }

    .restaurant-header h1 {
      font-size: 2.5em;
      color: #333;
    }

    .menu-container {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
      gap: 20px;
    }

    .menu-card {
      background-color: #fff;
      border-radius: 12px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
      overflow: hidden;
      display: flex;
      flex-direction: column;
      height: 100%;
      transition: transform 0.2s;
    }

    .menu-card:hover {
      transform: scale(1.02);
    }

    .menu-image {
      width: 100%;
      height: 200px;
      object-fit: cover;
    }

    .menu-info {
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      padding: 16px;
      flex-grow: 1;
    }

    .menu-info h3 {
      margin-bottom: 8px;
      font-size: 1.3em;
      color: #222;
    }

    .menu-info p {
      color: #666;
      font-size: 0.95em;
      margin-bottom: 10px;
    }

    .menu-bottom {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-top: auto;
    }

    .price {
      font-weight: bold;
      color: #e53935;
      font-size: 1.1em;
    }

    .rating {
      background-color: #4caf50;
      color: white;
      padding: 4px 8px;
      border-radius: 6px;
      font-size: 0.9em;
    }
  </style>
</head>
<body>

  <div class="restaurant-header">
    <h1>Menu </h1>
  </div>

  <div class="menu-container">
    <%
      List<Menu> menudetails = (List<Menu>) request.getAttribute("getallmenus");
      if (menudetails != null) {
        for (Menu menu : menudetails) {
    %>
      <div class="menu-card">
        <img src="<%= menu.getImagepath() %>" alt="Menu Item" class="menu-image">
        <div class="menu-info">
          <h3><%= menu.getItemname() %></h3>
          <p><%= menu.getDescription() %></p>
          <div class="menu-bottom">
            <span class="price">₹<%= menu.getPrice() %></span>
            <span class="rating">⭐ <%= menu.getRating() %></span>
          </div>
        </div>
      </div>
      
      <% 
      System.out.println(menu.getRestaurantid());
      %>
      <form action="cart" method="post">
	
	<input type="hidden" name="menuid" value="<%=menu.getMenuid()%>">
	<input type="hidden" name="quantity" value="1">
	<input type="hidden" name="restaurantid" value="<%= menu.getRestaurantid() %>">
	<input type="hidden" name="price" value="<%= menu.getPrice() %>">
	<input type="hidden" name="itemname" value="<%= menu.getItemname() %>">
	
	<input type="hidden" name="action" value="add">
		<!--  input type="hidden" name="action" value="add"--> 
	
	<input type="submit" value="AddToCart">
	
	</form>
      
    <%
        }
      } else {
    %>
      <p>No menu items available.</p>
    <%
      }
    %>
  </div>

	</body>
</html>
