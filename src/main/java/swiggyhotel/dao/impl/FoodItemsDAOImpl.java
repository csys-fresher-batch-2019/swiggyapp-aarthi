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
import swiggyhotel.dao.FoodItemsDAO;

import swiggyhotel.model.FoodDetails;
import java.util.ArrayList;
import java.util.List;

import swiggyhotel.model.FoodDetails;

public class FoodItemsDAOImpl implements FoodItemsDAO {
	

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
	
	public List<FoodDetails> findAll() throws Exception
	{  


		List<FoodDetails> l=new ArrayList<FoodDetails>();
		Connection con = null;
		Statement stmt = null;
		try {
		con=ConnectionUtil.getConnection();
		stmt=con.createStatement();
		String sql="select * from foodstuff_items";
		ResultSet ro=stmt.executeQuery(sql);
		
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
		//return l;
		}
		catch (Exception e) {
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
		//return l;
		return l;
		
		
		
		
	}

	

	

       public void updateMenuId(int menuId,String itemName)throws Exception {
    	   Connection con = null;
   		   Statement stmt = null;	   
	    try {
		    con=ConnectionUtil.getConnection();
		 stmt=con.createStatement();
		
	
		String sqlQuery="update foodstuff_items set menu_id='"+menuId+"' where item_name='"+itemName+"'";
		System.out.print(sqlQuery);
		int row1=stmt.executeUpdate(sqlQuery);
		 System.out.print(row1+"row updated");
		}
		catch (Exception e) {
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
	}

	public void insertItems(int itemId,String itemName,String foodType,int price,String images) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();;
		try {
		String sqlQuery="insert into foodstuff_items(item_id,item_name,food_type,price,images)values('"+itemId+"','"+itemName+"','"+foodType+"','"+price+"','"+images+"')";
		System.out.print(sqlQuery);
		int row=stmt.executeUpdate(sqlQuery);
		 System.out.print(row+"row inserted");
		}
		catch (Exception e) {
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
		
	}
	public void getFoodDetails(String foodType) throws Exception
	{
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
		try {
		String sql1="select item_name,price from foodstuff_items where food_type='"+foodType+"'";
		ResultSet ro1=stmt.executeQuery(sql1);
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro1.next())
		{   
			//FoodDetails ob=new FoodDetails();
			/*int id=ro1.getInt("item_id");
			System.out.println(id);*/
			String name=ro1.getString("item_name");
			System.out.println(name);
			/*String cate=ro1.getString("food_type");
			System.out.println(cate);*/
			int pri=ro1.getInt("price");
			System.out.println(pri);
			/*int menuid=ro1.getInt("menu_id");
			System.out.println(menuid);*/
		}
		}
		catch (Exception e) {
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
	}
	public void getItemName(int menuId) throws Exception
	{
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
		try {
		String sql1="select item_name from foodstuff_items where menu_id='"+menuId+"'";
		ResultSet ro1=stmt.executeQuery(sql1);
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro1.next())
		{   
			//FoodDetails ob=new FoodDetails();
			String name=ro1.getString("item_name");
			System.out.println(name);
			
		}
		}
		catch (Exception e) {
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
	







	





	





	
	





	





	
	
	
	 
	 
	 

	
	


