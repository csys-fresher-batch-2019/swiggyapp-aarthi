package swiggyhotel.dao;
import java.util.List;
import swiggyhotel.model.DbException;
import swiggyhotel.model.FoodDetails;
import swiggyhotel.model.MenuDetails;
public interface MenusDAO 
 {
	public List<MenuDetails> findAll() throws DbException;
	public void getCategory() throws DbException;
	public List<FoodDetails> getFoods() throws DbException;
	public List<FoodDetails> getSnacksAndShakes() throws DbException;
	public List<FoodDetails> getDesserts() throws DbException;
    public void getItemNameAndPrice(String itemName)throws DbException;
 }
