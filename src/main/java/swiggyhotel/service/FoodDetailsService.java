package swiggyhotel.service;

import java.util.List;

import org.jdbi.v3.core.Jdbi;

import swiggyhotel.Util.ConnectionUtil;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.FoodDetails;

public class FoodDetailsService {
	private Jdbi jdbi = ConnectionUtil.getjdbi();
	private FoodItemsDAO fooditem = jdbi.onDemand(FoodItemsDAO.class);

	public int insertItems(String itemName, String foodType, int price, int menuId, String images) throws DbException {
		return fooditem.save(itemName, foodType, price, menuId, images);

	}

	public int updateMenuId(int MenuId, String itemName) throws DbException {
		return fooditem.updateMenuId(MenuId, itemName);

	}

	public int deleteFoods(String itemName) throws DbException {
		return fooditem.deleteItem(itemName);
	}

	public List<FoodDetails> findAll() throws DbException {
		return fooditem.findAll();
	}

	public List<FoodDetails> getFoodsDetailsBySearchName(String searchname) throws DbException {
		return fooditem.findBySearchName(searchname);

	}

	public List<FoodDetails> getFoodDetails(String foodType) throws DbException {
		return fooditem.findByFoodType(foodType);

	}

}
