package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.Date;
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
import swiggyhotel.model.ItemNames;

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

	

	@Override
	public List<ItemList> getItemList(int orderId) throws DbException {
		
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
	public String getItemName(int itemId) throws DbException {
		String sql1="select item_name from foodstuff_items where item_id=? ";
		//List<ItemNames> list=new ArrayList<ItemNames>();
		String itemName=null;
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql1)){
		pst.setInt(1,itemId);
		try(ResultSet ro1=pst.executeQuery()){
			
		if(ro1.next())
		{   
			//ItemNames ob=new ItemNames();
			itemName=ro1.getString("item_name");
			//list.add(ob);
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return itemName;
	}

	
	

}
