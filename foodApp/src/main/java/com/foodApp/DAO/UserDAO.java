package com.foodApp.DAO;

import java.util.List;

import com.foodApp.models.User;

public interface UserDAO {

	void addUser(User user);
	User getUserDetailsById(int userid);
	void deleteUser(int userId);
	void updateUserDetails(User user);
	List<User>getAllUsers();
<<<<<<< HEAD
	
	boolean checkEmailExists(String email);
	User getUserDetailsByEmail(String email);

=======
>>>>>>> branch 'main' of https://github.com/Prasadhprasadh/foodApp_Application
}
