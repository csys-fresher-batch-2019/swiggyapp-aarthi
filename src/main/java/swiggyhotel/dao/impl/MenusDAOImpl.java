package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import swiggyhotel.ConnectionUtil;

//import java.util.ArrayList;

import swiggyhotel.dao.MenusDAO;
import swiggyhotel.model.MenuDetails;

public class MenusDAOImpl implements MenusDAO{

	    public List<MenuDetails> FindAll() throws Exception {
		Connection con=ConnectionUtil.getConnection();
		List<MenuDetails> l=new ArrayList<MenuDetails>();
		Statement stmt=con.createStatement();
		String sql1="select * from menus";
		ResultSet ro1=stmt.executeQuery(sql1);
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro1.next())
		{   
			MenuDetails ob=new MenuDetails();
			ob.menuId=ro1.getInt("menu_id");
			//System.out.println(id);
			ob.category=ro1.getString("category");
			//System.out.println(name);
			l.add(ob);
		}
		return l;
		
	}

	public void getCategory() throws Exception {
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
		String sql1="select category from menus";
		ResultSet ro1=stmt.executeQuery(sql1);
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro1.next())
		{   
			//FoodDetails ob=new FoodDetails();
			
			String cate=ro1.getString("category");
			System.out.println(cate);
			
		}
	}

	public void getItemNameAndPrice() throws Exception {
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
		String sql1="select item_name,price from foodstuff_items";
		ResultSet ro1=stmt.executeQuery(sql1);
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

	public void getItemNameAndPrice(String itemName) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		//Statement stmt=con.createStatement();
		String sql1="select item_name,price from foodstuff_items where item_name like ?";
		PreparedStatement pst=con.prepareStatement(sql1);
		pst.setString(1, "%"+itemName+"%");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			//UserDetails ob1=new UserDetails();
		    String itemName1=rs.getString("item_name");
		    System.out.println(itemName1);
		    String price1=rs.getString("price");
		    System.out.println(price1);
		    
		}
	}

}
