package swiggyhotel.dao;

import java.util.List;

import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.OrderItemDetails;

public interface OrderItemDAO {
	public List<OrderItemDetails> findAll() throws DbException;

	public String updateStatus(int orderId, String comments) throws DbException;

	public int save(OrderItemDetails ab) throws DbException;
}
