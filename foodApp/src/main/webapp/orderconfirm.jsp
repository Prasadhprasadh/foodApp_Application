

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodApp.models.Order" %>

<%
    Order order = (Order) session.getAttribute("order");
    if (order == null) {
        response.sendRedirect("home.jsp"); // or cart.jsp or error page
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation | FoodieApp</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fefefe;
            margin: 0;
            padding: 0;
        }

        .confirmation-container {
            max-width: 600px;
            margin: 80px auto;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h2 {
            color: #28a745;
            margin-bottom: 20px;
        }

        .details {
            text-align: left;
            margin-top: 20px;
            font-size: 16px;
        }

        .details p {
            margin: 8px 0;
        }

        .back-btn {
            display: inline-block;
            margin-top: 25px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            text-decoration: none;
            border-radius: 6px;
        }

        .back-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="confirmation-container">
    <h2>Thank you for your order!</h2>
    
    <div class="details">
        <p><strong>Order ID:</strong> <%= order.getOrderid() %></p>
        <p><strong>Total Amount:</strong> ₹<%= order.getTotalamount() %></p>
        <p><strong>Payment Mode:</strong> <%= order.getPaymentmode() %></p>
        <p><strong>Status:</strong> <%= order.getStatus() %></p>
        <p><strong>Order Date:</strong> <%= order.getOrderdate() %></p>
    </div>

    <a href="restaurant" class="back-btn">Back to Home</a>
</div>

<%-- Optionally clear the order after displaying --%>
<%
    session.removeAttribute("order");
%>

</body>
</html>
