package com.aarthi.swiggyhotel.service;

import com.aarthi.swiggyhotel.dao.DAOFactory;
import com.aarthi.swiggyhotel.dao.OrderDAO;
import com.aarthi.swiggyhotel.exception.DbException;
import com.aarthi.swiggyhotel.model.Order;


public class OrderService {
	private OrderDAO order = DAOFactory.getOrderDAO();

	public int updateDeliveredDateAndStatus(int orderId) throws DbException {
		return order.updateDeliveredDateAndStatus(orderId);
	}

	public int calculateTotalAmts(int orderId) throws DbException {
		return order.findTotalAmt(orderId);
	}

	public int updateTotalAmts(int orderId) throws DbException {
		return order.updateTotalAmt(orderId);
	}

	public int insertOrders(Order ob) throws DbException {
		return order.save(ob);
	}

	public int updateDeliveredDate(int orderId) throws DbException {
		return order.updateDeliveredDate(orderId);
	}

}
