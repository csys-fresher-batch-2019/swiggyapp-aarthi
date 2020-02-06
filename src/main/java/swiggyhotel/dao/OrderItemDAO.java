package swiggyhotel.dao;

import java.util.ArrayList;
import java.util.List;

import swiggyhotel.model.OrderItemDetails;

public interface OrderItemDAO {
	public List<OrderItemDetails> findAll() throws Exception;
	//public void getOrderIdAndQuantity(int orderId) throws Exception;
	//public void getOrderIdAndStatus(int orderItemId) throws Exception;
	public void updateStatus(int orderId,String comments) throws Exception;

}
