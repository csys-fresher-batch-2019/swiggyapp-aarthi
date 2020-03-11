package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import swiggyhotel.dao.UsersDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.logger.LoggerUtil;
import swiggyhotel.model.UserDetails;
import swiggyhotel.util.ConnectionUtil;

public class UsersDAOImpl implements UsersDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public List<UserDetails> findAll() throws DbException {
		List<UserDetails> l = new ArrayList<UserDetails>();
		String sql = "select user_id,user_name,phone_No,address,city from users";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					UserDetails ob = new UserDetails();
					ob.setUserId(ro.getInt("user_id"));
					ob.setUserName(ro.getString("user_name"));
					ob.setPhoneNo(ro.getLong("phone_No"));
					ob.setAddress(ro.getString("address"));
					ob.setCity(ro.getString("city"));
					l.add(ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (l);
	}

	public HashMap<String, Integer> findByNameAndTotalAmt(int orderId) throws DbException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String sqlQuery = "select user_name,total_amt from users u,orders o where u.user_id=o.user_id and order_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setInt(1, orderId);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					String username = rs.getString("user_name");
					int totalAmount = rs.getInt("total_amt");
					map.put(username, totalAmount);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public String findByNameAndPhoneNo(String name, Long phoneno) throws DbException {
		String message = " ";
		String sql = "select user_name,phone_no from users where user_name=? and phone_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, name);
			pst.setLong(2, phoneno);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					message = "Welcome " + name;
				} else {
					message = "Login Failure";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	public int save(UserDetails ob) throws DbException {
		String sql = "insert into users(user_id,user_name,phone_no,address,city) values(user_id.nextval,?,?,?,?)";
		int row = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, ob.getUserName());
			pst.setLong(2, ob.getPhoneNo());
			pst.setString(3, ob.getAddress());
			pst.setString(4, ob.getCity());
			row = pst.executeUpdate();
			logger.info(row + "row inserted");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	public int findUserId(String name, Long phoneno) throws DbException {
		String sql = "select user_id from users where user_name=? and phone_no=?";
		int userId = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, name);
			pst.setLong(2, phoneno);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					userId = rs.getInt("user_id");
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

	public String findByNameAndPassWord(String userName, String passWord) throws DbException {
		String msg = " ";
		if (userName.equalsIgnoreCase("admin") && passWord.equalsIgnoreCase("admin")) {
			msg = "Welcome";
		} else {
			msg = "Login Failure";
		}

		return msg;
	}

	public int findOrderId(int userId) throws DbException {
		String sql1 = "select order_id from orders where user_id=?";
		int orderId = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1)) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					orderId = rs.getInt("order_id");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderId;
	}

	public int ValidNumber(Long phoneNo) throws DbException {
		String sql1 = "select 1 from users where phone_no=?";
		int row = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1)) {
			pst.setLong(1, phoneNo);
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					row++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return row;
	}
}
