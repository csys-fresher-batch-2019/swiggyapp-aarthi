package swiggyhotel.dao.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.OrdersDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.OrderDetails;
//import java.sql.Date;
public class OrdersDAOImpl implements OrdersDAO {
	public static final LoggerUtil logger=LoggerUtil.getInstance();
	public void getOrderDetails() throws DbException {
		String sql1="select * from orders";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql1)){
		
		try(ResultSet ro1=pst.executeQuery(sql1)){
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro1.next())
		{   
			//FoodDetails ob=new FoodDetails();
			int id=ro1.getInt("order_id");
			logger.debug(id);
			int userId=ro1.getInt("user_id");
			logger.debug(userId);
			Date orderdate=ro1.getDate("ordered_date");
			logger.debug(orderdate);
			Date deliverDate=ro1.getDate("delivered_date");
			logger.debug(deliverDate);
			int totAmts=ro1.getInt("total_amt");
			logger.debug(totAmts);
		    String statusInfo=ro1.getString("status_info");
			logger.debug(statusInfo);
			String comment=ro1.getString("comments");
			logger.debug(comment);
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateDeliveredDateAndStatus(int orderId) throws DbException {
		String sqlQuery="update orders set delivered_date=systimestamp,status_info='delivered' where order_id=?";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sqlQuery)){
	     pst.setInt(1,orderId);
		logger.debug(sqlQuery);
		int row1=pst.executeUpdate(sqlQuery);
		logger.info(row1+"row updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void calculateTotalAmts(int orderId) throws DbException {
		
	   String sql="select sum(total_amounts) as amounts from order_items where order_id=?"; 
	   try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
		   pst.setInt(1,orderId);
		try( ResultSet ro=pst.executeQuery(sql)){
	if(ro.next())
		{   
			int totalAmts=ro.getInt("amounts");
			logger.debug(totalAmts);
		}
	   }
	   }
	   catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateTotalAmts(int orderId) throws DbException {
		
		//ResultSet ro=stmt.executeQuery(sql);
	    String sql="update orders set total_amt = ( select sum(total_amounts)as amounts from order_items  where order_id=?)  where order_id =?" ; 
	    try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
	    	pst.setInt(1,orderId);
	    	pst.setInt(2,orderId);
	        System.out.print(sql);
		    int row1=pst.executeUpdate(sql);
		    logger.info(row1+"row updated");
	    }
	    catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void insertOrders(OrderDetails obj) throws DbException {
		 String sql="insert into orders(order_id,user_id,ordered_date,total_amt,after_discount,approxDeliveryTime)values(?,?,?,?,?,?)" ; 
		 try(Connection con=ConnectionUtil.getConnection(); PreparedStatement pst=con.prepareStatement(sql)){
	    
		
		 //Date rd=Date.valueOf(orderDate);
		 //Date rd1=Date.valueOf(deliverDate);
		 pst.setInt(1,obj.orderId);
		 pst.setInt(2,obj.userId);
		 pst.setTimestamp(3,Timestamp.valueOf(obj.orderedDate));
		 pst.setInt(4,obj.totalAmts);
		 pst.setInt(5,obj.afterDiscount);
		 pst.setTimestamp(6,Timestamp.valueOf(obj.approxDeliveryTime));
		 int row1=pst.executeUpdate();
		 logger.info(row1+"row inserted");
		 }
		 catch(Exception e)
			{
				e.printStackTrace();
			}
		 
	}

	public void updateDeliveredDate(int orderId) throws DbException {
		 String sql="select ordered_date from orders where order_id=?";	 
		 try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
			 pst.setInt(1,orderId);
	     try(ResultSet rs=pst.executeQuery()){
	     
	     
	     String s=null;
	     if(rs.next())
	     {
	    	 s=rs.getTimestamp("ordered_date")+" ";
	    	 logger.debug(s);
	    	 
	    	/*String a[]=s.split("\\s");
	    	 String x=a[0];
	    	 String y=a[1];
	    	 String b[]=y.split(":");
	    	 String z=b[0];
	    	 int x1=Integer.parseInt(z);*/
	    	 
	    	 
	     }
	     }
		 }
		 catch(Exception e)
			{
				e.printStackTrace();
			}
	   /*String sql1="update orders set delivered_date=to_char(to_date(?, 'YYYY-MM-DD HH:MI:SS pm') + 1/24, 'YYYY-MM-DD HH:MI:SS pm') where order_id=?";
	    PreparedStatement pst1=con.prepareStatement(sql1);
	    pst1.setString(1, s);
	    pst1.setInt(2,orderId);
	    int row1=pst1.executeUpdate();
	    System.out.print(row1+"row inserted");*/
	     
	}



	

	
	

}
