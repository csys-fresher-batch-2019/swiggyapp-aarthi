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
import swiggyhotel.dao.OrdersDAO;
import swiggyhotel.model.OrderDetails;
//import java.sql.Date;
public class OrdersDAOImpl implements OrdersDAO {

	public void getOrderDetails() throws Exception {
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
		String sql1="select * from orders";
		ResultSet ro1=stmt.executeQuery(sql1);
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro1.next())
		{   
			//FoodDetails ob=new FoodDetails();
			int id=ro1.getInt("order_id");
			System.out.println(id);
			int userId=ro1.getInt("user_id");
			System.out.println(userId);
			Date orderdate=ro1.getDate("ordered_date");
			System.out.println(orderdate);
			Date deliverDate=ro1.getDate("delivered_date");
			System.out.println(deliverDate);
			int totAmts=ro1.getInt("total_amt");
			System.out.println(totAmts);
		    String statusInfo=ro1.getString("status_info");
			System.out.println(statusInfo);
			String comment=ro1.getString("comments");
			System.out.println(comment);
		}
	}

	public void updateDeliveredDateAndStatus(int orderId) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
	    String sqlQuery="update orders set delivered_date=systimestamp,status_info='delivered' where order_id='"+orderId+"'"; 
		System.out.print(sqlQuery);
		int row1=stmt.executeUpdate(sqlQuery);
		 System.out.print(row1+"row updated");
	}

	public void calculateTotalAmts(int orderId) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
	    String sql="select sum(total_amounts) as amounts from order_items where order_id='"+orderId+"'"; 
	    ResultSet ro=stmt.executeQuery(sql);
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		if(ro.next())
		{   
			//FoodDetails ob=new FoodDetails();
			int totalAmts=ro.getInt("amounts");
			System.out.println(totalAmts);
		}
		//return totalAmts;
	}

	public void updateTotalAmts(int orderId) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
		//ResultSet ro=stmt.executeQuery(sql);
	    String sql="update orders set total_amt = ( select sum(total_amounts)as amounts from order_items  where order_id='"+orderId+"')  where order_id ='"+orderId+"'" ; 
	    System.out.print(sql);
	   // ResultSet ro=stmt.executeQuery(sql);
		int row1=stmt.executeUpdate(sql);
		//ResultSet ro=stmt.executeQuery(sql);
		System.out.print(row1+"row updated");
		
	}

	public void insertOrders(OrderDetails obj) throws Exception {
		 Connection con=ConnectionUtil.getConnection();
	     String sql="insert into orders(order_id,user_id,ordered_date,total_amt,after_discount,approxDeliveryTime)values(?,?,?,?,?,?)" ; 
		 PreparedStatement pst=con.prepareStatement(sql);
		 //Date rd=Date.valueOf(orderDate);
		 //Date rd1=Date.valueOf(deliverDate);
		 pst.setInt(1,obj.orderId);
		 pst.setInt(2,obj.userId);
		 pst.setTimestamp(3,Timestamp.valueOf(obj.orderedDate));
		 pst.setInt(4,obj.totalAmts);
		 pst.setInt(5,obj.afterDiscount);
		 pst.setTimestamp(6,Timestamp.valueOf(obj.approxDeliveryTime));
		 int row1=pst.executeUpdate();
		 System.out.print(row1+"row inserted");
		 
	}

	public void updateDeliveredDate(int orderId) throws Exception {
		 Connection con=ConnectionUtil.getConnection();
	     String sql="select ordered_date from orders where order_id=?";	
	     PreparedStatement pst=con.prepareStatement(sql);
	     pst.setInt(1,orderId);
	     ResultSet rs=pst.executeQuery();
	     String s=null;
	     if(rs.next())
	     {
	    	 s=rs.getTimestamp("ordered_date")+" ";
	    	 System.out.println(s);
	    	 
	    	/*String a[]=s.split("\\s");
	    	 String x=a[0];
	    	 String y=a[1];
	    	 String b[]=y.split(":");
	    	 String z=b[0];
	    	 int x1=Integer.parseInt(z);*/
	    	 
	    	 
	     }
	   /*String sql1="update orders set delivered_date=to_char(to_date(?, 'YYYY-MM-DD HH:MI:SS pm') + 1/24, 'YYYY-MM-DD HH:MI:SS pm') where order_id=?";
	    PreparedStatement pst1=con.prepareStatement(sql1);
	    pst1.setString(1, s);
	    pst1.setInt(2,orderId);
	    int row1=pst1.executeUpdate();
	    System.out.print(row1+"row inserted");*/
	     
	}



	

	
	

}
