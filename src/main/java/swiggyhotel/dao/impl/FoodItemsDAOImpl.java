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
	/*public void insertItems(int itemId,String itemName,String foodType,int price)throws Exception {
		Connection con = null;
		Statement stmt = null;
		try {
			con=ConnectionUtil.getConnection();
			stmt=con.createStatement();
			String sqlQuery="insert into foodstuff_items(item_id,item_name,categories,price,menu_id)"
					+ "values('"+itemId+"','"+itemName+"','"+foodType+"','"+price+"')";
			System.out.print(sqlQuery);
			int row=stmt.executeUpdate(sqlQuery);
			 System.out.print(row);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (stmt != null ) {
				stmt.close();
			}
			if ( con != null) {
				con.close();
			}
		}
		//return null;
		
		
		
	}*/
	
	public List<FoodDetails> findAll() throws DbException
	{  
        List<FoodDetails> l=new ArrayList<FoodDetails>();
		String sql="select * from foodstuff_items";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)) {
		try(ResultSet ro=pst.executeQuery(sql)){
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
		int row1=pst.executeUpdate(sqlQuery);
		logger.info(row1+"row updated");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		

	

	public void insertItems(int itemId,String itemName,String foodType,int price,String images) throws DbException {
		String sqlQuery="insert into foodstuff_items(item_id,item_name,food_type,price,images)values(?,?,?,?,?)";
		
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sqlQuery)) {
		pst.setInt(1, itemId);
		pst.setString(2, itemName);
		pst.setString(3, foodType);
		pst.setInt(4,price);
		pst.setString(5,images);
		
		logger.debug(sqlQuery);
		int row=pst.executeUpdate(sqlQuery);
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
		
		try(ResultSet ro1=pst.executeQuery(sql1)){
	      pst.setString(1,foodType);
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
	/*public void getItemName(int menuId) throws Exception
	{
		String sql1="select item_name from foodstuff_items where menu_id=?";
		
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql1);) {
		
		try(ResultSet ro1=pst.executeQuery(sql1);){
	    pst.setInt(1,menuId);
		while(ro1.next())
		{   
			
			String name=ro1.getString("item_name");
			System.out.println(name);
			
		}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/
	public List<FoodDetails> getFoodsDetailsBySearchName(String searchname) throws DbException
	{  


		List<FoodDetails> l1=new ArrayList<FoodDetails>();
		String sql="select * from foodstuff_items where item_name like ? or food_type like ?";
		
		try (Connection con =ConnectionUtil.getConnection();PreparedStatement pst =con.prepareStatement(sql)){
		
		
		try(ResultSet ro=pst.executeQuery(sql)){
			
		pst.setString(1,"%"+searchname+"%");
		pst.setString(2,"%"+searchname+"%");
		
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

}
	







	





	





	
	





	





	
	
	
	 
	 
	 

	
	


