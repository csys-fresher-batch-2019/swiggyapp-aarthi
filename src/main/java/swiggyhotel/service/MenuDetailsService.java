package swiggyhotel.service;

import java.util.List;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.MenusDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.FoodDetails;
import swiggyhotel.model.MenuDetails;

public class MenuDetailsService {
	private MenusDAO menu = DAOFactory.getMenusDAO();

	public List<MenuDetails> findAll() throws DbException {
		return menu.findAll();
	}

	public List<MenuDetails> getCategory() throws DbException {
		return menu.findCategory();
	}

	public List<FoodDetails> getFoods() throws DbException {
		return menu.findFoods();

	}

	public List<FoodDetails> getSnacksAndShakes() throws DbException {
		return menu.findSnacksAndShakes();

	}

	public List<FoodDetails> getDesserts() throws DbException {
		return menu.findDesserts();
	}

	public List<FoodDetails> getItemNameAndPrice(String itemName) throws DbException {
		return menu.findByItemName(itemName);
	}

	public String toUpp(String word) throws DbException {
		return menu.toUpp(word);
	}

}
