package swiggyhotel.dao;
import swiggyhotel.model.DbException;
import swiggyhotel.model.OrderDetails;
public interface OrdersDAO
 {
	public void updateDeliveredDateAndStatus(int orderId) throws DbException;
	public int calculateTotalAmts(int orderId) throws DbException;
	public void updateTotalAmts(int orderId) throws DbException;
	public int insertOrders(OrderDetails ob)throws DbException;
	public void updateDeliveredDate(int orderId)throws DbException;
 }
