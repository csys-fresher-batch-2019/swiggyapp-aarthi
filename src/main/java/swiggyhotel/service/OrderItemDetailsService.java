package swiggyhotel.service;

import java.util.List;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrderItemDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.OrderItemDetails;

public class OrderItemDetailsService {
	private OrderItemDAO orderitem = DAOFactory.getOrderItemDAO();

	public int insertorderitems(OrderItemDetails ab) throws DbException {
		return orderitem.save(ab);
	}

	public List<OrderItemDetails> findAll() throws DbException {
		return orderitem.findAll();
	}

	public String updateStatus(int orderId, String comments) throws DbException {
		return orderitem.updateStatus(orderId, comments);
	}

}
