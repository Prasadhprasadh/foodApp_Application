

<h1>  This is Checkout Page </h1>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Checkout </title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 40px;
        }

        .checkout-container {
            background-color: white;
            max-width: 500px;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        textarea, select, input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
            resize: vertical;
        }

        .submit-btn {
            margin-top: 25px;
            background-color: #28a745;
            color: white;
            padding: 12px;
            width: 100%;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .submit-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="checkout-container">
    <h2>Checkout</h2>

    <form action="checkout" method="post">
        <!-- Hidden input to indicate checkout action -->
        <input type="hidden" name="action" value="checkout">

        <!-- Delivery Address -->
        <label for="address">Delivery Address:</label>
        <textarea name="address" id="address" rows="4" placeholder="Enter your full delivery address..." required></textarea>

        <!-- Payment Mode -->
        <label for="paymentMode">Payment Mode:</label>
        <select name="paymentMode" id="paymentMode" required>
            <option value="">-- Select Payment Mode --</option>
            <option value="COD">Cash on Delivery</option>
            <option value="UPI">UPI</option>
            <option value="Card">Credit/Debit Card</option>
        </select>

        <!-- Submit -->
        <button type="submit" class="submit-btn">Place Order</button>
    </form>
</div>

</body>
</html>
