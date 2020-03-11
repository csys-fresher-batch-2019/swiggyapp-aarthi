package swiggyhotel.dao;

import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.OrderDetails;

public interface OrdersDAO {
	public int updateDeliveredDateAndStatus(int orderId) throws DbException;

	public int findTotalAmt(int orderId) throws DbException;

	public int updateTotalAmt(int orderId) throws DbException;

	public int save(OrderDetails ob) throws DbException;

	public int updateDeliveredDate(int orderId) throws DbException;
}
