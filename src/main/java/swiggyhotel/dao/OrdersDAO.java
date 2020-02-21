package swiggyhotel.dao;

//import java.sql.Date;
//import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;

import swiggyhotel.model.DbException;

//import java.util.ArrayList;

import swiggyhotel.model.OrderDetails;

public interface OrdersDAO {
	
	
	//public void getOrderDetails() throws Exception;
	public void updateDeliveredDateAndStatus(int orderId) throws DbException;
	public int calculateTotalAmts(int orderId) throws DbException;
	public void updateTotalAmts(int orderId) throws DbException;
	public int insertOrders(OrderDetails ob)throws DbException;
	public void updateDeliveredDate(int orderId)throws DbException;
	
	

}
