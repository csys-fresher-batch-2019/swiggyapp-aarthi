package swiggyhotel.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;

//import java.util.ArrayList;

import swiggyhotel.dao.MenusDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.MenuDetails;

public class MenusDAOImpl implements MenusDAO{
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	    public List<MenuDetails> FindAll() throws DbException {
	    List<MenuDetails> l=new ArrayList<MenuDetails>();
	    String sql1="select * from menus";
	    try(Connection con=ConnectionUtil.getConnection();PreparedStatement stmt=con.prepareStatement(sql1)){
		
	    try(ResultSet ro1=stmt.executeQuery(sql1)){
		
		while(ro1.next())
		{   
			MenuDetails ob=new MenuDetails();
			ob.menuId=ro1.getInt("menu_id");
			//System.out.println(id);
			ob.category=ro1.getString("category");
			//System.out.println(name);
			l.add(ob);
		}
	    }
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		return l;
		
	}

	public void getCategory() throws DbException {
		String sql1="select category from menus";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement stmt=con.prepareStatement(sql1)){
		
		try(ResultSet ro1=stmt.executeQuery(sql1)){
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro1.next())
		{   
			//FoodDetails ob=new FoodDetails();
			
			String cate=ro1.getString("category");
			logger.debug(cate);
			
		}
		}
	    }
		catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	
	
	}

	/*public void getItemNameAndPrice() throws Exception {
		String sql1="select item_name,price from foodstuff_items";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement stmt=con.prepareStatement(sql1);){
		
		try(ResultSet ro1=stmt.executeQuery(sql1);){
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro1.next())
		{   
			//FoodDetails ob=new FoodDetails();
			String name=ro1.getString("item_name");
			System.out.println(name);
			int cost=ro1.getInt("price");
			System.out.println(cost);
			
		}
		}
		}
		catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}*/

	public void getItemNameAndPrice(String itemName) throws DbException {
		
		//Statement stmt=con.createStatement();
		String sql1="select item_name,price from foodstuff_items where item_name like ?";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql1)){
			pst.setString(1, "%"+itemName+"%");
			try(ResultSet rs=pst.executeQuery()){
		
		
		while(rs.next())
		{
			//UserDetails ob1=new UserDetails();
		    String itemName1=rs.getString("item_name");
		    logger.debug(itemName1);
		    String price1=rs.getString("price");
		    logger.debug(price1);
		    
		}
		}
		}
		catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		
	}

}
