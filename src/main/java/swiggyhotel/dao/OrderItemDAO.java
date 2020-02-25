package swiggyhotel.dao;
import java.util.List;
import swiggyhotel.model.DbException;
import swiggyhotel.model.OrderItemDetails;
public interface OrderItemDAO
 {
	public List<OrderItemDetails> findAll() throws DbException;
	public void updateStatus(int orderId,String comments) throws DbException;
	public void insertorderitems(OrderItemDetails ab)throws DbException;
 }
