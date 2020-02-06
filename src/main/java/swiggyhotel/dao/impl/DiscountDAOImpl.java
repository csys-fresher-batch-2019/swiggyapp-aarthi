package swiggyhotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.ArrayList;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.dao.DiscountDAO;

public class DiscountDAOImpl implements DiscountDAO {

	public  int calculateDiscountAmt(int orderId) throws Exception {
           
		Connection con = null;
		Statement stmt = null;
		 float discount=0;
		 int discountAmt=0;
		try {
		con=ConnectionUtil.getConnection();
		stmt=con.createStatement();
		String sql="select total_amt from orders where order_id='"+orderId+"' ";
		ResultSet ro=stmt.executeQuery(sql);
		
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
         catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return discountAmt;
		finally {
			if (stmt != null ) {
				stmt.close();
			}
			if ( con != null) {
				con.close();
			}
		}
		
		return discountAmt;
	}

	public void updateDiscountAmt(int orderId) throws Exception {
		//DiscountDAOImpl ob=new DiscountDAOImpl();
		int discount =calculateDiscountAmt(orderId);
		Connection con = null;
		PreparedStatement pst=null;
		try {
		//con=ConnectionUtil.getConnection();
		String sql="update orders set after_discount=?  where order_id=?";
		con=ConnectionUtil.getConnection();
		pst=con.prepareStatement(sql);
		pst.setInt(1,discount);
		pst.setInt(2,orderId);
		int rows=pst.executeUpdate();
		System.out.print(rows+ "row updated" );
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (pst != null ) {
				pst.close();
			}
			if ( con != null) {
				con.close();
			}
		}
		
		
		
		
	}

	
		
	

}
