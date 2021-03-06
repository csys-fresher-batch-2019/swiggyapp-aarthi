package com.aarthi.swiggyhotel.service;

import java.util.List;

import com.aarthi.swiggyhotel.dao.DAOFactory;
import com.aarthi.swiggyhotel.dao.MenuDAO;
import com.aarthi.swiggyhotel.exception.DbException;
import com.aarthi.swiggyhotel.model.FoodItem;
import com.aarthi.swiggyhotel.model.Menu;


public class MenuService {
	private MenuDAO menu = DAOFactory.getMenuDAO();

	public List<Menu> findAll() throws DbException {
		return menu.findAll();
	}

	public List<Menu> getCategory() throws DbException {
		return menu.findCategory();
	}

	public List<FoodItem> getFoods() throws DbException {
		return menu.findFoods();

	}

	public List<FoodItem> getSnacksAndShakes() throws DbException {
		return menu.findSnacksAndShakes();

	}

	public List<FoodItem> getDesserts() throws DbException {
		return menu.findDesserts();
	}

	public List<FoodItem> getItemNameAndPrice(String itemName) throws DbException {
		return menu.findByItemName(itemName);
	}

	public String toUpp(String word) throws DbException {
		return menu.toUpp(word);
	}

}
