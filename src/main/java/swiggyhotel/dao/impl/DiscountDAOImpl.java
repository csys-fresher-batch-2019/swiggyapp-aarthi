package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.DiscountDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.ItemList;

public class DiscountDAOImpl implements DiscountDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public int calculateDiscountAmt(int orderId) throws DbException {

		float discount = 0;
		int discountAmt = 0;
		String sql = "select total_amt from orders where order_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			try (ResultSet ro = pst.executeQuery()) {
				int amt = 0;
				if (ro.next()) {
					amt = ro.getInt("total_amt");
				}
				if (amt >= 100 && amt <= 999) {
					discount = (float) (amt * .10);
				} else if (amt >= 1000 && amt <= 1999) {
					discount = (float) (amt * .25);
				} else {
					discount = (float) (amt * .50);
				}

				discountAmt = amt - (int) discount;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return discountAmt;

	}

	public void updateDiscountAmt(int orderId) throws DbException {
		int discount = calculateDiscountAmt(orderId);
		String sql = "update orders set after_discount=?  where order_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, discount);
			pst.setInt(2, orderId);
			int rows = pst.executeUpdate();
			logger.info(rows + "row updated");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*public int getOrderItemId() {
		int orderItemId = 0;

		String sql = "select order_item_id.nextval as orderItemId from dual";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			if (rs.next()) {
				orderItemId = rs.getInt("orderItemId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderItemId;

	}*/

	@Override
	public List<ItemList> getItemList(int orderId) throws DbException {
		//int orderItemId = getOrderItemId();
		String sql = "select order_id,item_id,quantity,total_amounts,status,order_date from order_items where order_id=?";

		List<ItemList> list = new ArrayList<ItemList>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					ItemList ob = new ItemList();
					ob.orderId = ro.getInt("order_id");
					ob.itemId = ro.getInt("item_id");
					ob.quantity = ro.getInt("quantity");
					ob.totalAmount = ro.getInt("total_amounts");
					ob.status = ro.getString("status");
					ob.orderedDate = (ro.getTimestamp("order_date").toLocalDateTime());
					// ob.itemName=ro.getString("item_name");
					// ob.foodType=ro.getString("food_type");
					// ob.price=ro.getInt("price");
					// ob.quantity=ro.getInt("quantity");
					// ob.totalAmount=ro.getInt(arg0)
					// ob.menuId=ro.getInt("menu_id");
					// ob.images=ro.getString("images");
					list.add(ob);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
		// return null;
	}

}
