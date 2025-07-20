<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ page import="com.foodApp.models.Restaurant,java.util.List" %>

	<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>FoodieApp - Restaurant Card</title>
  <style>
    /* Navbar Styles */
    .navbar {
      background-color: #fc8019;
      color: white;
      padding: 15px 30px;
      display: flex;
      justify-content: space-between;
      align-items: center;
      font-family: Arial, sans-serif;
    }

    .navbar h1 {
      margin: 0;
      font-size: 24px;
    }

    .navbar ul {
      list-style: none;
      margin: 0;
      padding: 0;
      display: flex;
    }

    .navbar ul li {
      margin-left: 20px;
    }

    .navbar ul li a {
      color: white;
      text-decoration: none;
      font-weight: bold;
    }

    /* Restaurant Card Styles */
    .restaurant-card {
      background-color: white;
      border-radius: 10px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
      display: flex;
      margin: 30px;
      overflow: hidden;
      max-width: 600px;
      font-family: Arial, sans-serif;
    }

    .restaurant-image {
      width: 200px;
      height: 150px;
      object-fit: cover;
    }

    .restaurant-info {
      padding: 15px;
      flex: 1;
    }

    .restaurant-info h2 {
      margin: 0 0 10px 0;
    }

    .restaurant-meta {
      display: flex;
      justify-content: space-between;
      font-size: 14px;
      color: #555;
    }

    .rating {
      background-color: #48c479;
      color: white;
      padding: 4px 8px;
      border-radius: 5px;
      font-weight: bold;
    }
  </style>
</head>
<body>

  <!-- Navbar -->
  <div class="navbar">
    <h1>FoodieApp</h1>
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">Offers</a></li>
      <li><a href="#">Cart</a></li>
      <li><a href="#">Login</a></li>
    </ul>
  </div>

<% 
  List<Restaurant>	restaurants=
 (List<Restaurant>) session.getAttribute("allRestaurantsDetails");

for(Restaurant res:restaurants){
	%>
	<a href="menu?restaurantId=<%= res.getRestaurantId()%>">
	<div class="restaurant-card">
    <img class="restaurant-image" src="<%= res.getImagePath() %>" alt="Spicy Treat">
      
    <div class="restaurant-info">
      <h2><%=res.getName() %></h2>
      <p><%=res.getAddress()%></p>
      <div class="restaurant-meta">
        <span>ETA: <%=res.getDeliveryTime() %></span>
        <span class="rating"><%=res.getRating() %>★</span>
      </div>
    </div>
     </a>
  </div>

<%}
%>

  
</body>
</html>
    