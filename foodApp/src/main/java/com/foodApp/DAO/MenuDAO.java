package com.foodApp.DAO;

import java.util.List;

import com.foodApp.models.Menu;

public interface MenuDAO {

	void addItemintoMenu(Menu menu);
	Menu getmenuById(int menuid);
	List<Menu> getAllMenu();
	void updateMenu(Menu menu);
	void deleteMenuById(int id);
}
