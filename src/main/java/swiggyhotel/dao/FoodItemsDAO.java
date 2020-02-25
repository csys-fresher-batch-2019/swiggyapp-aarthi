package swiggyhotel.dao;
import java.util.List;
import swiggyhotel.model.DbException;
import swiggyhotel.model.FoodDetails;
public interface FoodItemsDAO
 {
	public void insertItems(String itemName,String foodType,int price,int menuId,String images) throws DbException;
	public void updateMenuId(int MenuId,String itemName) throws DbException;
	public List<FoodDetails> findAll() throws DbException;
	public List<FoodDetails> getFoodsDetailsBySearchName(String searchname) throws DbException;
	public void getFoodDetails(String foodType) throws DbException;
	public void deleteFoods(String itemName)throws DbException;
	public String toUpp(String word)throws DbException;
 }
