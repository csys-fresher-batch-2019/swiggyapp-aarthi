package swiggyhotel.dao;

//import java.sql.Date;
//import java.time.LocalDate;

import java.time.LocalDate;

//import java.util.ArrayList;

import swiggyhotel.model.OrderDetails;

public interface OrdersDAO {
	
	
	//public void getOrderDetails() throws Exception;
	public void updateDeliveredDateAndStatus(int orderId) throws Exception;
	public void calculateTotalAmts(int orderId) throws Exception;
	public void updateTotalAmts(int orderId) throws Exception;
	public void insertOrders(OrderDetails ob)throws Exception;
	public void updateDeliveredDate(int orderId)throws Exception;
	
	

}
