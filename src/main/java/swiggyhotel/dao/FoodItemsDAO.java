package swiggyhotel.dao;

import java.util.ArrayList;
import java.util.List;

import swiggyhotel.model.DbException;
import swiggyhotel.model.FoodDetails;



public interface FoodItemsDAO {
	/*public ArrayList<FoodDetails> getFoodDetails(int itemId,String itemName
			,String foodType,int price );*/
	
	public void insertItems(int itemId,String itemName,
			String foodType,int price,String images) throws DbException;
	public void updateMenuId(int MenuId,String itemName) throws DbException;
	public List<FoodDetails> findAll() throws DbException;
	public List<FoodDetails> getFoodsDetailsBySearchName(String searchname) throws DbException;
	public void getFoodDetails(String foodType) throws DbException;
	//public void getItemName(int menuId) throws Exception;
	//public void deleteItemId(int itemId) throws Exception;
	
	

}
