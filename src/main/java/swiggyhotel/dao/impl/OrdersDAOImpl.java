package swiggyhotel.dao.impl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.OrdersDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.OrderDetails;
public class OrdersDAOImpl implements OrdersDAO {
	public static final LoggerUtil logger=LoggerUtil.getInstance();
	public void getOrderDetails() throws DbException {
		String sql1="select * from orders";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql1)){
		try(ResultSet ro1=pst.executeQuery()){
		while(ro1.next())
		{   
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
		int row1=pst.executeUpdate();
		logger.info(row1+"row updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
public int calculateTotalAmts(int orderId) throws DbException {
	   String sql="select sum(total_amounts) as amounts from order_items where order_id=?"; 
	   int totalAmts=0;
	   try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
		   pst.setInt(1,orderId);
	   try( ResultSet ro=pst.executeQuery()){
	   if(ro.next())
		 {   
			totalAmts=ro.getInt("amounts");
			logger.debug(totalAmts);
		}
	   }
	   }
	   catch(Exception e)
		{
			e.printStackTrace();
		}
	return totalAmts;
	}
public void updateTotalAmts(int orderId) throws DbException {
		String sql="update orders set total_amt = ( select sum(total_amounts)as amounts from order_items  where order_id=?)  where order_id =?" ; 
	    try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
	    	pst.setInt(1,orderId);
	    	pst.setInt(2,orderId);
	        System.out.print(sql);
		    int row1=pst.executeUpdate();
		    logger.info("row updated"+row1);
	    }
	    catch(Exception e)
		{
			e.printStackTrace();
		}
	}
public int getOrderId() {
		int orderId = 0;
        String sql = "select order_id.nextval as orderId from dual";
		try(Connection con=ConnectionUtil.getConnection(); PreparedStatement pst=con.prepareStatement(sql); ResultSet rs=  pst.executeQuery()){
		    if(rs.next()) {
		    	orderId = rs.getInt("orderId");
		    }
		 } 
		catch (Exception e) {
			e.printStackTrace();
		}
		return orderId;
	}
public int insertOrders(OrderDetails obj) throws DbException {
		int orderId = getOrderId();
		System.out.println("ORderID=" + orderId);
		String sql="insert into orders(order_id,user_id,ordered_date,approxDeliveryTime)values(?,?,?,?)" ; 
		try(Connection con=ConnectionUtil.getConnection(); PreparedStatement pst=con.prepareStatement(sql)){
	     
		pst.setInt(1, orderId);
		 pst.setInt(2,obj.getUserId());
		 pst.setTimestamp(3,Timestamp.valueOf(obj.getOrderedDate()));
		 
		 pst.setTimestamp(4,Timestamp.valueOf(obj.getApproxDeliveryTime()));
		 int row1=pst.executeUpdate();
		 logger.info(row1+"row inserted");
		 }
		 catch(Exception e)
			{
				e.printStackTrace();
			}
	return orderId;	 
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
	     }
	     }
		 }
		 catch(Exception e)
		  {
				e.printStackTrace();
		  }
	}
}
