package swiggyhotel.dao;

import java.util.List;

import swiggyhotel.model.DbException;

//import java.util.ArrayList;

import swiggyhotel.model.MenuDetails;

public interface MenusDAO {
	
	public List<MenuDetails> FindAll() throws DbException;
	public void getCategory() throws DbException;
	
	public void getItemNameAndPrice(String itemName)throws DbException;
	

}
