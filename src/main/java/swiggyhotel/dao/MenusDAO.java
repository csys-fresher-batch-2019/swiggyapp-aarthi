package swiggyhotel.dao;

import java.util.List;

import swiggyhotel.model.DbException;
import swiggyhotel.model.FoodDetails;

//import java.util.ArrayList;

import swiggyhotel.model.MenuDetails;
import swiggyhotel.model.OrderItems;

public interface MenusDAO {
	
	public List<MenuDetails> FindAll() throws DbException;
	public void getCategory() throws DbException;
	public List<FoodDetails> getFoods() throws DbException;
	public List<FoodDetails> getSnacksAndShakes() throws DbException;
	public List<FoodDetails> getDesserts() throws DbException;
    public void getItemNameAndPrice(String itemName)throws DbException;
  
}
