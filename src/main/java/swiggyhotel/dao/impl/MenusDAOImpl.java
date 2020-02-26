package swiggyhotel.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.MenusDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.FoodDetails;
import swiggyhotel.model.MenuDetails;
public class MenusDAOImpl implements MenusDAO{
	public static final LoggerUtil logger=LoggerUtil.getInstance();
	public List<MenuDetails> findAll() throws DbException {
	    List<MenuDetails> l=new ArrayList<MenuDetails>();
	    String sql1="select * from menus";
	    try(Connection con=ConnectionUtil.getConnection();PreparedStatement stmt=con.prepareStatement(sql1)){
		try(ResultSet ro1=stmt.executeQuery()){
		while(ro1.next())
		{   
			MenuDetails ob=new MenuDetails();
			ob.setMenuId(ro1.getInt("menu_id"));
			
			ob.setCategory(ro1.getString("category"));
			
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
		try(ResultSet ro1=stmt.executeQuery()){
		while(ro1.next())
		{   
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
public void getItemNameAndPrice(String itemName) throws DbException {
		String sql1="select item_name,price from foodstuff_items where item_name like ?";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql1)){
			pst.setString(1, "%"+itemName+"%");
		try(ResultSet rs=pst.executeQuery()){
		while(rs.next())
		{
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
@Override
public List<FoodDetails> getFoods() throws DbException {
		 List<FoodDetails> l=new ArrayList<FoodDetails>();
		 String sql="select f.item_id,f.item_name,f.food_type,f.price,f.images from foodstuff_items f,menus m where f.menu_id=m.menu_id and  m.menu_id=1";
		 try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)) {
		 try(ResultSet ro=pst.executeQuery()){
		 while(ro.next())
			{   
				FoodDetails ob=new FoodDetails();
				ob.setItemId(ro.getInt("item_id"));
				ob.setItemName(ro.getString("item_name"));
				ob.setFoodType(ro.getString("food_type"));
			    ob.setPrice(ro.getInt("price"));
				ob.setImages(ro.getString("images"));
				l.add(ob);
	        }
			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return l;
	}
@Override
public List<FoodDetails> getSnacksAndShakes() throws DbException {
		 List<FoodDetails> l=new ArrayList<FoodDetails>();
		 String sql="select f.item_id,f.item_name,f.food_type,f.price,f.images from foodstuff_items f,menus m where f.menu_id=m.menu_id and m.menu_id=2";
		 try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)) {
		 try(ResultSet ro=pst.executeQuery()){
		 while(ro.next())
			{   
				FoodDetails ob=new FoodDetails();
				ob.setItemId(ro.getInt("item_id"));
				ob.setItemName(ro.getString("item_name"));
				ob.setFoodType(ro.getString("food_type"));
			    ob.setPrice(ro.getInt("price"));
				ob.setImages(ro.getString("images"));
				l.add(ob);
	        }
			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return l;
	}
@Override
public List<FoodDetails> getDesserts() throws DbException {
		 List<FoodDetails> l=new ArrayList<FoodDetails>();
		 String sql="select f.item_id,f.item_name,f.food_type,f.price,f.images from foodstuff_items f,menus m where f.menu_id=m.menu_id and m.menu_id=3";
		 try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)) {
		 try(ResultSet ro=pst.executeQuery()){
		 while(ro.next())
			{   
				FoodDetails ob=new FoodDetails();
				ob.setItemId(ro.getInt("item_id"));
				ob.setItemName(ro.getString("item_name"));
				ob.setFoodType(ro.getString("food_type"));
			    ob.setPrice(ro.getInt("price"));
				ob.setImages(ro.getString("images"));
				l.add(ob);
	        }
			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return l;
	}
}


