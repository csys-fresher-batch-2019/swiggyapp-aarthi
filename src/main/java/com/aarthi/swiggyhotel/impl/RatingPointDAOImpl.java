package com.aarthi.swiggyhotel.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aarthi.swiggyhotel.dao.RatingPointDAO;
import com.aarthi.swiggyhotel.exception.DbException;
import com.aarthi.swiggyhotel.model.RatingPoint;
import com.aarthi.swiggyhotel.util.ConnectionUtil;
import com.aarthi.swiggyhotel.util.LoggerUtil;



public class RatingPointDAOImpl implements RatingPointDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public List<RatingPoint> findAll() throws DbException {
		List<RatingPoint> l = new ArrayList<RatingPoint>();
		String sqlQuery = "select user_id,item_id,rating_points from ratings";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sqlQuery)) {
			try (ResultSet ro = stmt.executeQuery()) {
				while (ro.next()) {
					RatingPoint ob = new RatingPoint();
					int a = ro.getInt("user_id");
					int b = ro.getInt("item_id");
					int c = ro.getInt("rating_points");
					ob.setUserId(a);
					ob.setItemId(b);
					ob.setRatingPoints(c);
					l.add(ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	public int save(RatingPoint ob) throws DbException {
		String sqlQuery = "insert into ratings(user_id,item_id,rating_points) values(?,?,?)";
		int row = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setInt(1, ob.getUserId());
			pst.setInt(2, ob.getItemId());
			pst.setInt(3, ob.getRatingPoint());
			row = pst.executeUpdate();
			logger.info(row + "row inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	public int findRate(String itemName) throws DbException {
		List<RatingPoint> ratings = findByItemName(itemName);
		int sum = 0;
		float avg = 0;
		int rate = 0;
		for (RatingPoint ratingDetails : ratings) {
			sum = sum + ratingDetails.getRatingPoint();
		}
		if (!ratings.isEmpty()) {
			avg = (float) (sum / ratings.size());
			rate = (int) avg;
		}
		return rate;
	}

	public List<RatingPoint> findByItemName(String itemName) throws DbException {
		int sum = 0, c = 0;
		String query = "select r.user_id,f.item_id, f.item_name, r.rating_points from ratings r,foodstuff_items f where f.item_id=r.item_id and item_name=? order by r.created_date desc";
		List<RatingPoint> list = new ArrayList<RatingPoint>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(query);) {
			pst.setString(1, itemName);
			try (ResultSet ro1 = pst.executeQuery()) {
				while (ro1.next()) {
					RatingPoint ob = new RatingPoint();
					ob.setUserId(ro1.getInt("user_id"));
					ob.setItemId(ro1.getInt("item_id"));
					ob.setItemName(ro1.getString("item_name"));
					ob.setRatingPoints(ro1.getInt("rating_points"));
					sum = sum + ob.getRatingPoint();
					c++;
					list.add(ob);
				}
				float avg = 0;
				if (c != 0) {
					avg = sum / c;
				}
				logger.debug((int) avg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
