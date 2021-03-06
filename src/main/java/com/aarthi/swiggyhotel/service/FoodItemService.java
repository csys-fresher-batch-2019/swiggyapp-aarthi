package com.aarthi.swiggyhotel.service;

import java.util.List;

import org.jdbi.v3.core.Jdbi;

import com.aarthi.swiggyhotel.dao.FoodItemDAO;
import com.aarthi.swiggyhotel.exception.DbException;
import com.aarthi.swiggyhotel.model.FoodItem;
import com.aarthi.swiggyhotel.util.ConnectionUtil;

public class FoodItemService {
	private Jdbi jdbi = ConnectionUtil.getjdbi();
	private FoodItemDAO fooditem = jdbi.onDemand(FoodItemDAO.class);

	public int insertItems(String itemName, String foodType, int price, int menuId, String images) throws DbException {
		return fooditem.save(itemName, foodType, price, menuId, images);

	}

	public int updateMenuId(int MenuId, String itemName) throws DbException {
		return fooditem.updateMenuId(MenuId, itemName);

	}

	public int deleteFoods(String itemName) throws DbException {
		return fooditem.deleteItem(itemName);
	}

	public List<FoodItem> findAll() throws DbException {
		return fooditem.findAll();
	}

	public List<FoodItem> getFoodsDetailsBySearchName(String searchname) throws DbException {
		return fooditem.findBySearchName(searchname);

	}

	public List<FoodItem> getFoodDetails(String foodType) throws DbException {
		return fooditem.findByFoodType(foodType);

	}

}
