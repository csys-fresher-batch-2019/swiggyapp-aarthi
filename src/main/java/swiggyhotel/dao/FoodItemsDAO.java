package swiggyhotel.dao;

import java.util.ArrayList;
import java.util.List;

import swiggyhotel.model.FoodDetails;



public interface FoodItemsDAO {
	/*public ArrayList<FoodDetails> getFoodDetails(int itemId,String itemName
			,String foodType,int price );*/
	
	public void insertItems(int itemId,String itemName,
			String foodType,int price,String images) throws Exception;
	public void updateMenuId(int MenuId,String itemName) throws Exception;
	public List<FoodDetails> findAll() throws Exception;
	public void getFoodDetails(String foodType) throws Exception;
	public void getItemName(int menuId) throws Exception;
	//public void deleteItemId(int itemId) throws Exception;
	
	

}
