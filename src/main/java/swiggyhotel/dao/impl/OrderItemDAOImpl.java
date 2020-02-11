package swiggyhotel.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.OrderItemDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.OrderItemDetails;
import swiggyhotel.model.UserDetails;

//import java.util.ArrayList;

public class OrderItemDAOImpl implements OrderItemDAO {
	public static final LoggerUtil logger=LoggerUtil.getInstance();
	/*public void getOrderIdAndQuantity(int orderId) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
		String sql1="select order_id,sum(quantity) as quantity from order_items where order_id='"+orderId+"' group by order_id";
		ResultSet ro1=stmt.executeQuery(sql1);
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		if(ro1.next())
		{   
			//FoodDetails ob=new FoodDetails();
			int id=ro1.getInt("order_id");
			System.out.println(id);
			int qty=ro1.getInt("quantity");
			System.out.println(qty);
			
		}
	}*/
		
	

	/*public void getOrderIdAndStatus(int orderItemId) throws Exception {
		Connection con=ConnectionUtil.getConnection();
		Statement stmt=con.createStatement();
		String sql1="select order_id,status from order_items where order_item_id='"+orderItemId+"'";
		ResultSet ro1=stmt.executeQuery(sql1);
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro1.next())
		{   
			//FoodDetails ob=new FoodDetails();
			int id=ro1.getInt("order_id");
			System.out.println(id);
			String status=ro1.getString("status");
			System.out.println(status);
	}
		
		
	}*/

	public void updateStatus(int orderId,String comments) throws DbException {
		try(Connection con=ConnectionUtil.getConnection();CallableStatement cstmt=con.prepareCall("{call procedure1(?,?)}")){
		cstmt.setInt(1,orderId);
		cstmt.setString(2,comments);
		boolean flag=cstmt.execute();
	    logger.debug(flag);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  
		
	}



	public List<OrderItemDetails> findAll() throws DbException {
		List<OrderItemDetails> l=new ArrayList<OrderItemDetails>();
		String sql="select * from order_items";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
		
		
		try(ResultSet ro=pst.executeQuery(sql)){
		//List<FoodDetails> l=new ArrayList<FoodDetails>();
		while(ro.next())
		{   
			//FoodDetails ob=new FoodDetails();
			OrderItemDetails ob=new OrderItemDetails();
			ob.orderItemId=ro.getInt("order_item_id");
			ob.orderId=ro.getInt("order_id");
			ob.itemId=ro.getInt("item_id");
			ob.quantity=ro.getInt("quantity");
		    ob.totalAmounts=ro.getInt("total_amounts");
		    ob.status=ro.getString("status");
		    ob.orderDate=ro.getDate("order_date");
			l.add(ob);
		}
		}
		}
		catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		
		return(l);
		
		
		//return null;
	}
}
