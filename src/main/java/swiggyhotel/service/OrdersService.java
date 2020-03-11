package swiggyhotel.service;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrdersDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.OrderDetails;

public class OrdersService {
	private OrdersDAO order = DAOFactory.getOrdersDAO();

	public int updateDeliveredDateAndStatus(int orderId) throws DbException {
		return order.updateDeliveredDateAndStatus(orderId);
	}

	public int calculateTotalAmts(int orderId) throws DbException {
		return order.findTotalAmt(orderId);
	}

	public int updateTotalAmts(int orderId) throws DbException {
		return order.updateTotalAmt(orderId);
	}

	public int insertOrders(OrderDetails ob) throws DbException {
		return order.save(ob);
	}

	public int updateDeliveredDate(int orderId) throws DbException {
		return order.updateDeliveredDate(orderId);
	}

}
