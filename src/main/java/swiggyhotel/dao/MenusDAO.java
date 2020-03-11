package swiggyhotel.dao;

import java.util.List;

import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.FoodDetails;
import swiggyhotel.model.MenuDetails;

public interface MenusDAO {
	public List<MenuDetails> findAll() throws DbException;

	public List<MenuDetails> findCategory() throws DbException;

	public List<FoodDetails> findFoods() throws DbException;

	public List<FoodDetails> findSnacksAndShakes() throws DbException;

	public List<FoodDetails> findDesserts() throws DbException;

	public List<FoodDetails> findByItemName(String itemName) throws DbException;

	public String toUpp(String word) throws DbException;
}
