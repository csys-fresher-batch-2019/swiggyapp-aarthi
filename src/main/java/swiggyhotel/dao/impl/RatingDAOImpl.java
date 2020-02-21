package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.RatingDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.RatingDetails;

public class RatingDAOImpl implements RatingDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public List<RatingDetails> findAll() throws DbException {
		List<RatingDetails> l = new ArrayList<RatingDetails>();

		String sqlQuery = "select * from ratings";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sqlQuery)) {
			try (ResultSet ro = stmt.executeQuery()) {

				while (ro.next()) {
					RatingDetails ob = new RatingDetails();

					int a = ro.getInt("user_id");
					ob.setUserId(a);
					int b = ro.getInt("item_id");
					ob.setItemId(b);
					int c = ro.getInt("rating_points");
					ob.setRatingPoints(c);

					l.add(ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	public void insertRatings(RatingDetails ob) throws DbException {
		String sqlQuery = "insert into ratings(user_id,item_id,rating_points) values(?,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setInt(1, ob.getUserId());
			pst.setInt(2, ob.getItemId());
			pst.setInt(3, ob.getRatingPoints());
			int row = pst.executeUpdate();
			logger.info(row + "row inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getItemRatings(String itemName) throws DbException {
		
		List<RatingDetails> ratings = getRatings(itemName);
		int sum = 0;
		float avg = 0;
		int rate=0;
		for (RatingDetails ratingDetails : ratings) {
			sum = sum+  ratingDetails.ratingPoints;
		}
		if (! ratings.isEmpty()) {
		   avg = (float)(sum / ratings.size());
		   rate=(int)avg;
		}
		//logger.debug(avg);
		return rate;
	}
	
	public List<RatingDetails> getRatings(String itemName) throws DbException {
		int sum = 0, c = 0;

		String query = "select f.item_id, f.item_name, r.rating_points from ratings r,foodstuff_items f where f.item_id=r.item_id and item_name=? order by r.created_date desc";
		List<RatingDetails> list = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(query);) {

			pst.setString(1, itemName);
			try (ResultSet ro1 = pst.executeQuery()) {
				
				while (ro1.next()) {
					RatingDetails ob = new RatingDetails();
					ob.setItemId(ro1.getInt("item_id"));
					ob.setItemName(ro1.getString("item_name"));
					ob.ratingPoints = ro1.getInt("rating_points");
					sum = sum + ob.ratingPoints;
					c++;
					list.add(ob);
				}
				float avg = 0;
				if ( c != 0) {
				 avg = sum / c;
				}
				logger.debug((int) avg);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

}
