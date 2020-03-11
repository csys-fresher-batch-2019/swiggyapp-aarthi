package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import swiggyhotel.dao.MenusDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.logger.LoggerUtil;
import swiggyhotel.model.FoodDetails;
import swiggyhotel.model.MenuDetails;
import swiggyhotel.util.ConnectionUtil;

public class MenusDAOImpl implements MenusDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public List<MenuDetails> findAll() throws DbException {
		List<MenuDetails> l = new ArrayList<MenuDetails>();
		String sql1 = "select menu_id,category from menus";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql1)) {
			try (ResultSet ro1 = stmt.executeQuery()) {
				while (ro1.next()) {
					MenuDetails ob = new MenuDetails();
					ob.setMenuId(ro1.getInt("menu_id"));

					ob.setCategory(ro1.getString("category"));

					l.add(ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public List<MenuDetails> findCategory() throws DbException {
		String sql1 = "select category from menus";
		List<MenuDetails> l3 = new ArrayList<MenuDetails>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql1)) {
			try (ResultSet ro1 = stmt.executeQuery()) {
				while (ro1.next()) {
					MenuDetails ob = new MenuDetails();
					ob.setCategory(ro1.getString("category"));
					l3.add(ob);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l3;
	}

	public List<FoodDetails> findByItemName(String itemName) throws DbException {
		String sql1 = "select item_name,price from foodstuff_items where item_name like ?";
		List<FoodDetails> l4 = new ArrayList<FoodDetails>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1)) {
			pst.setString(1, "%" + itemName + "%");
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					FoodDetails obj = new FoodDetails();
					obj.setItemName(rs.getString("item_name"));
					obj.setPrice(rs.getInt("price"));
					l4.add(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l4;
	}

	@Override
	public List<FoodDetails> findFoods() throws DbException {
		List<FoodDetails> l = new ArrayList<FoodDetails>();
		String sql = "select f.item_id,f.item_name,f.food_type,f.price,f.images from foodstuff_items f,menus m where f.menu_id=m.menu_id and  m.menu_id=1";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					FoodDetails ob = new FoodDetails();
					ob.setItemId(ro.getInt("item_id"));
					ob.setItemName(ro.getString("item_name"));
					ob.setFoodType(ro.getString("food_type"));
					ob.setPrice(ro.getInt("price"));
					ob.setImages(ro.getString("images"));
					l.add(ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public List<FoodDetails> findSnacksAndShakes() throws DbException {
		List<FoodDetails> l = new ArrayList<FoodDetails>();
		String sql = "select f.item_id,f.item_name,f.food_type,f.price,f.images from foodstuff_items f,menus m where f.menu_id=m.menu_id and m.menu_id=2";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					FoodDetails ob = new FoodDetails();
					ob.setItemId(ro.getInt("item_id"));
					ob.setItemName(ro.getString("item_name"));
					ob.setFoodType(ro.getString("food_type"));
					ob.setPrice(ro.getInt("price"));
					ob.setImages(ro.getString("images"));
					l.add(ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<FoodDetails> findDesserts() throws DbException {
		List<FoodDetails> l = new ArrayList<FoodDetails>();
		String sql = "select f.item_id,f.item_name,f.food_type,f.price,f.images from foodstuff_items f,menus m where f.menu_id=m.menu_id and m.menu_id=3";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					FoodDetails ob = new FoodDetails();
					ob.setItemId(ro.getInt("item_id"));
					ob.setItemName(ro.getString("item_name"));
					ob.setFoodType(ro.getString("food_type"));
					ob.setPrice(ro.getInt("price"));
					ob.setImages(ro.getString("images"));
					l.add(ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public String toUpp(String word) throws DbException {
		String first = word.substring(0, 1);
		String f_after = word.substring(1);
		String res = first.toUpperCase() + f_after;
		return (res);
	}
}
