package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import java.sql.Connection;
//import java.sql.Connection;
//import java.util.ArrayList;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.FoodDetails;
import java.util.ArrayList;
import java.util.List;

import swiggyhotel.model.FoodDetails;

public class FoodItemsDAOImpl implements FoodItemsDAO {
	
	public static final LoggerUtil logger=LoggerUtil.getInstance();
	
	
	public List<FoodDetails> findAll() throws DbException
	{  
        List<FoodDetails> l=new ArrayList<FoodDetails>();
		String sql="select * from foodstuff_items";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)) {
		try(ResultSet ro=pst.executeQuery()){
		while(ro.next())
		{   
			FoodDetails ob=new FoodDetails();
			ob.itemId=ro.getInt("item_id");
			ob.itemName=ro.getString("item_name");
			ob.foodType=ro.getString("food_type");
		    ob.price=ro.getInt("price");
			ob.menuId=ro.getInt("menu_id");
			ob.images=ro.getString("images");
			l.add(ob);
        }
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return l;
	}

	

	

       public void updateMenuId(int menuId,String itemName)throws DbException {
    	   String sqlQuery="update foodstuff_items set menu_id=? where item_name=?";
    	      
	    try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sqlQuery)) {
		pst.setInt(1, menuId);
		pst.setString(2, itemName);
		
	    //logger.debug(sqlQuery);
		int row1=pst.executeUpdate();
		logger.info(row1+"row updated");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		

	

	public void insertItems(String itemName,String foodType,int price,int menuId,String images) throws DbException {
		String sqlQuery="insert into foodstuff_items(item_id,item_name,food_type,price,menu_id,images)values(item_id.nextval,?,?,?,?,?)";
		
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sqlQuery)) {
		//pst.setInt(1, itemId);
		pst.setString(1, itemName);
		pst.setString(2, foodType);
		pst.setInt(3,price);
		pst.setInt(4,menuId);
		pst.setString(5,images);
		
		logger.debug(sqlQuery);
		int row=pst.executeUpdate();
		logger.info(row+"row inserted");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getFoodDetails(String foodType) throws DbException
	{
		String sql1="select item_name,price from foodstuff_items where food_type=?";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql1)) {
			 pst.setString(1,foodType);
		try(ResultSet ro1=pst.executeQuery()){
	     
		while(ro1.next())
		{   
			
			String name=ro1.getString("item_name");
			logger.debug(name);
			int pri=ro1.getInt("price");
			logger.debug(pri);
			
		}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<FoodDetails> getFoodsDetailsBySearchName(String searchname) throws DbException
	{  


		List<FoodDetails> l1=new ArrayList<FoodDetails>();
		String sql="select * from foodstuff_items where item_name like ?";
		
		try (Connection con =ConnectionUtil.getConnection();PreparedStatement pst =con.prepareStatement(sql)){
		
			pst.setString(1,"%"+searchname+"%");
		try(ResultSet ro=pst.executeQuery()){
			
		
		
		
		while(ro.next())
		{   
			FoodDetails ob=new FoodDetails();
			ob.itemId=ro.getInt("item_id");
			ob.itemName=ro.getString("item_name");
			ob.foodType=ro.getString("food_type");
		    ob.price=ro.getInt("price");
			ob.menuId=ro.getInt("menu_id");
			ob.images=ro.getString("images");
			l1.add(ob);
        }
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return l1;
	}
	/*public void deleteItemId(int itemId) throws Exception
	{
		Connection con = null;
		PreparedStatement pst = null;	   
	    try {
		    con=ConnectionUtil.getConnection();
		 //stmt=con.createStatement();
	    String sqlQuery="delete from foodstuff_items where item_id=?";
		pst=con.prepareStatement(sqlQuery);
		pst.setInt(1,itemId);
		int row=pst.executeUpdate();
		System.out.println(row);
		System.out.print(sqlQuery);
		
		 //System.out.print(row1);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (pst != null ) {
				pst.close();
			}
			if ( con != null) {
				con.close();
			}
		}
	}*/





	@Override
	public void deleteFoods(String itemName) throws DbException {
    String sqlQuery="delete from foodstuff_items where item_name=?";
		
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sqlQuery)) {
		//pst.setInt(1, itemId);
		pst.setString(1, itemName);
		
		logger.debug(sqlQuery);
		int row=pst.executeUpdate();
		logger.info(row+"row deleted");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
	







	





	





	
	





	





	
	
	
	 
	 
	 

	
	


