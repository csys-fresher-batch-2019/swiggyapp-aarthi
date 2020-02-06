package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.dao.RatingDAO;
import swiggyhotel.model.RatingDetails;

public class RatingDAOImpl implements RatingDAO{

	public List<RatingDetails> findAll() throws Exception {
		List<RatingDetails> l=new ArrayList<RatingDetails>();
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
		String sqlQuery="select * from ratings";
		ResultSet ro=stmt.executeQuery(sqlQuery);
		while(ro.next())
		{
			RatingDetails ob=new RatingDetails();
			
			int a=ro.getInt("user_id");
			ob.setUserId(a);
			int b=ro.getInt("item_id");
			ob.setItemId(b);
			int c=ro.getInt("rating_points");
			ob.setRatingPoints(c);
			
			l.add(ob);		
		}
		
		return l;
	}


	public void insertRatings(RatingDetails ob) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		String sqlQuery="insert into ratings(user_id,item_id,rating_points) values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(sqlQuery);
		pst.setInt(1,ob.getUserId());
		pst.setInt(2,ob.getItemId());
		pst.setInt(3,ob.getRatingPoints());
		int row=pst.executeUpdate();
		System.out.println(row+"row inserted");
	}


	public void getRatings(String itemName) throws Exception {
		Connection con=ConnectionUtil.getConnection();
	    Statement stmt=con.createStatement();
		String sql1="select rating_points from ratings r,foodstuff_items f where f.item_id=r.item_id and item_name='"+itemName+"' order by rating_points desc";
		ResultSet ro1=stmt.executeQuery(sql1);
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		int temp=0;
		while(ro1.next())
		{   
			RatingDetails ob=new RatingDetails();
			ob.ratingPoints=ro1.getInt("rating_points");
			if(temp<ob.ratingPoints)
			{
			    temp=ob.ratingPoints;
			}
		}
		//avg=avg/c;
		System.out.println(temp);
			
	    
		
	}
}


