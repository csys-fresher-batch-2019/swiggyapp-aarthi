package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import swiggyhotel.Util.ConnectionUtil;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.logger.LoggerUtil;
import swiggyhotel.model.FoodDetails;

public class FoodItemsDAOImpl implements FoodItemsDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public List<FoodDetails> findAll() throws DbException {
		List<FoodDetails> l = new ArrayList<FoodDetails>();
		String sql = "select item_id,item_name,food_type,price,menu_id,images from foodstuff_items";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					FoodDetails ob = new FoodDetails();
					ob.setItemId(ro.getInt("item_id"));
					ob.setItemName(ro.getString("item_name"));
					ob.setFoodType(ro.getString("food_type"));
					ob.setPrice(ro.getInt("price"));
					ob.setMenuId(ro.getInt("menu_id"));
					ob.setImages(ro.getString("images"));
					l.add(ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public int updateMenuId(int menuId, String itemName) throws DbException {
		String sqlQuery = "update foodstuff_items set menu_id=? where item_name=?";
		int row1 = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setInt(1, menuId);
			pst.setString(2, itemName);
			row1 = pst.executeUpdate();
			logger.info(row1 + "row updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row1;
	}

	public int save(String itemName, String foodType, int price, int menuId, String images) throws DbException {
		String sqlQuery = "insert into foodstuff_items(item_id,item_name,food_type,price,menu_id,images)values(item_id.nextval,?,?,?,?,?)";
		int row = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setString(1, itemName);
			pst.setString(2, foodType);
			pst.setInt(3, price);
			pst.setInt(4, menuId);
			pst.setString(5, images);
			logger.debug(sqlQuery);
			row = pst.executeUpdate();
			logger.info(row + "row inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	public List<FoodDetails> findByFoodType(String foodType) throws DbException {
		String sql1 = "select item_name,price from foodstuff_items where food_type=?";
		List<FoodDetails> list = new ArrayList<FoodDetails>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1)) {
			pst.setString(1, foodType);
			try (ResultSet ro1 = pst.executeQuery()) {
				while (ro1.next()) {
					FoodDetails ob = new FoodDetails();
					ob.setItemName(ro1.getString("item_name"));
					ob.setPrice(ro1.getInt("price"));
					list.add(ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<FoodDetails> findBySearchName(String searchname) throws DbException {
		List<FoodDetails> l1 = new ArrayList<FoodDetails>();
		String sql = "select item_id,item_name,food_type,price,menu_id,images from foodstuff_items where item_name like ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, "%" + searchname + "%");
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					FoodDetails ob = new FoodDetails();
					ob.setItemId(ro.getInt("item_id"));
					ob.setItemName(ro.getString("item_name"));
					ob.setFoodType(ro.getString("food_type"));
					ob.setPrice(ro.getInt("price"));
					ob.setMenuId(ro.getInt("menu_id"));
					ob.setImages(ro.getString("images"));
					l1.add(ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return l1;
	}

	public int deleteItem(String itemName) throws DbException {
		String sqlQuery = "delete from foodstuff_items where item_name=?";
		int row = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setString(1, itemName);
			logger.debug(sqlQuery);
			row = pst.executeUpdate();
			logger.info(row + "row deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
}
