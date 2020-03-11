package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import swiggyhotel.dao.DiscountDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.logger.LoggerUtil;
import swiggyhotel.model.ItemList;
import swiggyhotel.util.ConnectionUtil;

public class DiscountDAOImpl implements DiscountDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public int findDiscount(int orderId) throws DbException {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return discountAmt;
	}

	public int updateDiscount(int orderId) throws DbException {
		int discount = findDiscount(orderId);
		int rows = 0;
		String sql = "update orders set after_discount=?  where order_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, discount);
			pst.setInt(2, orderId);
			rows = pst.executeUpdate();
			logger.info(rows + "row updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public List<ItemList> findByOrderId(int orderId) throws DbException {
		String sql = "select order_id,item_id,quantity,total_amounts,status,order_date from order_items where order_id=?";
		List<ItemList> list = new ArrayList<ItemList>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					ItemList ob = new ItemList();
					ob.setOrderId(ro.getInt("order_id"));
					ob.setItemId(ro.getInt("item_id"));
					ob.setQuantity(ro.getInt("quantity"));
					ob.setTotalAmount(ro.getInt("total_amounts"));
					ob.setStatus(ro.getString("status"));
					ob.setOrderedDate((ro.getTimestamp("order_date").toLocalDateTime()));
					list.add(ob);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String findItemName(int itemId) throws DbException {
		String sql1 = "select item_name from foodstuff_items where item_id=? ";
		String itemName = null;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1)) {
			pst.setInt(1, itemId);
			try (ResultSet ro1 = pst.executeQuery()) {
				if (ro1.next()) {
					itemName = ro1.getString("item_name");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemName;
	}
}
