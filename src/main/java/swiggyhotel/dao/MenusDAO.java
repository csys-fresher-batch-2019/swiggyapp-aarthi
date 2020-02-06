package swiggyhotel.dao;

import java.util.List;

//import java.util.ArrayList;

import swiggyhotel.model.MenuDetails;

public interface MenusDAO {
	
	public List<MenuDetails> FindAll() throws Exception;
	public void getCategory() throws Exception;
	public void getItemNameAndPrice() throws Exception;
	public void getItemNameAndPrice(String itemName)throws Exception;
	

}
