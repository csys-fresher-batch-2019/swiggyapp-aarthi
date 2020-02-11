package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.DiscountDAO;
import swiggyhotel.model.DbException;

public class DiscountDAOImpl implements DiscountDAO {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public  int calculateDiscountAmt(int orderId) throws DbException {
           
	
		float discount=0;
		int discountAmt=0;
		String sql="select total_amt from orders where order_id=?";
		try (Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
	    pst.setInt(1,orderId);
	    try(ResultSet ro=pst.executeQuery()){
		int amt = 0;
		if ( ro.next()) {
			amt = ro.getInt("total_amt");
		}
		if(amt>=100&&amt<=999)
		{
			discount=(float)(amt *.10);
		}
		else if(amt>=1000&&amt<=1999)
		{
			discount=(float)(amt *.25);
		}
		else
		{
			discount=(float)(amt *.50);
		}
	
		 discountAmt=amt-(int)discount;
	     }
			
		  }
	
           catch (Exception e) {
			e.printStackTrace();
			}
		return discountAmt;
		
		
		
	}

	public void updateDiscountAmt(int orderId) throws DbException {
		int discount =calculateDiscountAmt(orderId);
		String sql="update orders set after_discount=?  where order_id=?";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)) {
		pst.setInt(1,discount);
		pst.setInt(2,orderId);
		int rows=pst.executeUpdate();
		logger.info(rows+ "row updated" );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
		
	

}
