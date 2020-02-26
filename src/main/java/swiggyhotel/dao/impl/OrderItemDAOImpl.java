package swiggyhotel.dao.impl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import swiggyhotel.ConnectionUtil;
import swiggyhotel.LoggerUtil;
import swiggyhotel.dao.OrderItemDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.OrderItemDetails;
public class OrderItemDAOImpl implements OrderItemDAO {
	public static final LoggerUtil logger=LoggerUtil.getInstance();
	public void updateStatus(int orderId,String comments) throws DbException {
		try(Connection con=ConnectionUtil.getConnection();CallableStatement cstmt=con.prepareCall("{call updatestatus(?,?)}")){
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
	    try(ResultSet ro=pst.executeQuery()){
        while(ro.next())
		{   
			OrderItemDetails ob=new OrderItemDetails();
			ob.setOrderItemId(ro.getInt("order_item_id"));
			ob.setOrderId(ro.getInt("order_id"));
			ob.setItemId(ro.getInt("item_id"));
			ob.setQuantity(ro.getInt("quantity"));
		    ob.setTotalAmounts(ro.getInt("total_amounts"));
		    ob.setStatus(ro.getString("status"));
		    ob.setOrderDate((ro.getTimestamp("order_date").toLocalDateTime()));
		    l.add(ob);
		}
		}
		}
		catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		return(l);
	}
public void insertorderitems(OrderItemDetails ab) throws DbException {
		String sql="insert into order_items(order_item_id,order_id,item_id,quantity,total_amounts,order_date)values(order_item_id.nextval,?,?,?,?,?)" ; 
		try(Connection con=ConnectionUtil.getConnection(); PreparedStatement pst=con.prepareStatement(sql)){
	     pst.setInt(1,ab.getOrderId());
		 pst.setInt(2,ab.getItemId());
		 pst.setInt(3,ab.getQuantity());
		 pst.setInt(4,ab.getTotalAmounts());
		 pst.setTimestamp(5,Timestamp.valueOf(ab.getOrderDate()));
		 int row1=pst.executeUpdate();
		 logger.info(row1+"row inserted");
		 
		 }
		 catch(Exception e)
			{
				e.printStackTrace();
			}
	}
}
