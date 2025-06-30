package com.foodApp.DAO;

import java.util.List;

import com.foodApp.models.Restaurant;

public interface RestaurantDAO {

	void addRestaurantDetails(Restaurant restaurant);
	void deleteRestaurantById(int restaurantId);
	Restaurant getRestaurantById(int restaurantId);
	void updateRestaurantDetails(Restaurant restaurant);
	List<Restaurant> getAllRestaurantsDetails();
}
