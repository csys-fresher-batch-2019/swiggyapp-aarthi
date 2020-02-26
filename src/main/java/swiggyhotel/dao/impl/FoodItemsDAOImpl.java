package swiggyhotel.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.model.DbException;
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
			ob.setItemId(ro.getInt("item_id"));
			ob.setItemName(ro.getString("item_name"));
			ob.setFoodType(ro.getString("food_type"));
		    ob.setPrice(ro.getInt("price"));
			ob.setMenuId(ro.getInt("menu_id"));
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
public void updateMenuId(int menuId,String itemName)throws DbException {
    	String sqlQuery="update foodstuff_items set menu_id=? where item_name=?";
    	try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sqlQuery)) {
		pst.setInt(1, menuId);
		pst.setString(2, itemName);
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
			ob.setItemId(ro.getInt("item_id"));
			ob.setItemName(ro.getString("item_name"));
			ob.setFoodType(ro.getString("food_type"));
		    ob.setPrice(ro.getInt("price"));
			ob.setMenuId(ro.getInt("menu_id"));
			ob.setImages(ro.getString("images"));
			l1.add(ob);
        }
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return l1;
	}
@Override
public String toUpp(String word)throws DbException
	{
	  String first=word.substring(0,1);
	  String f_after=word.substring(1);
	  String res=first.toUpperCase()+f_after;
      return(res);
	}
@Override
public void deleteFoods(String itemName) throws DbException {
       String sqlQuery="delete from foodstuff_items where item_name=?";
	   try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sqlQuery)) {
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
	







	





	





	
	





	





	
	
	
	 
	 
	 

	
	


