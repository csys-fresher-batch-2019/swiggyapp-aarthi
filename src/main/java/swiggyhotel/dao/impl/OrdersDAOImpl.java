package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import swiggyhotel.Util.ConnectionUtil;
import swiggyhotel.dao.OrdersDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.logger.LoggerUtil;
import swiggyhotel.model.OrderDetails;

public class OrdersDAOImpl implements OrdersDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public int updateDeliveredDateAndStatus(int orderId) throws DbException {
		String sqlQuery = "update orders set delivered_date=systimestamp,status_info='delivered' where order_id=?";
		int row1 = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setInt(1, orderId);
			logger.debug(sqlQuery);
			row1 = pst.executeUpdate();
			logger.info(row1 + "row updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row1;
	}

	public int findTotalAmt(int orderId) throws DbException {
		String sql = "select sum(total_amounts) as amounts from order_items where order_id=?";
		int totalAmts = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			try (ResultSet ro = pst.executeQuery()) {
				if (ro.next()) {
					totalAmts = ro.getInt("amounts");
					logger.debug(totalAmts);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalAmts;
	}

	public int updateTotalAmt(int orderId) throws DbException {

		String sql = "update orders set total_amt = ( select sum(total_amounts)as amounts from order_items  where order_id=?)  where order_id =?";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			pst.setInt(2, orderId);
			System.out.print(sql);
			rows = pst.executeUpdate();
			logger.info("row updated" + rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	public int getOrderId() {
		int orderId = 0;
		String sql = "select order_id.nextval as orderId from dual";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			if (rs.next()) {
				orderId = rs.getInt("orderId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderId;
	}

	public int save(OrderDetails obj) throws DbException {
		int orderId = getOrderId();
		System.out.println("ORderID=" + orderId);
		String sql = "insert into orders(order_id,user_id,ordered_date,approxDeliveryTime)values(?,?,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, orderId);
			pst.setInt(2, obj.getUserId());
			pst.setTimestamp(3, Timestamp.valueOf(obj.getOrderedDate()));

			pst.setTimestamp(4, Timestamp.valueOf(obj.getApproxDeliveryTime()));
			int row1 = pst.executeUpdate();
			logger.info(row1 + "row inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderId;
	}

	public int updateDeliveredDate(int orderId) throws DbException {
		String sql = "select ordered_date from orders where order_id=?";
		int c = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			try (ResultSet rs = pst.executeQuery()) {
				String s = null;
				if (rs.next()) {
					s = rs.getTimestamp("ordered_date") + " ";
					logger.debug(s);
					c++;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
