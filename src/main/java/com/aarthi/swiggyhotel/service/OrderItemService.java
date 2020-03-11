package com.aarthi.swiggyhotel.service;

import java.util.List;

import com.aarthi.swiggyhotel.dao.DAOFactory;
import com.aarthi.swiggyhotel.dao.OrderItemDAO;
import com.aarthi.swiggyhotel.exception.DbException;
import com.aarthi.swiggyhotel.model.OrderItem;


public class OrderItemService {
	private OrderItemDAO orderitem = DAOFactory.getOrderItemDAO();

	public int insertorderitems(OrderItem ab) throws DbException {
		return orderitem.save(ab);
	}

	public List<OrderItem> findAll() throws DbException {
		return orderitem.findAll();
	}

	public String updateStatus(int orderId, String comments) throws DbException {
		return orderitem.updateStatus(orderId, comments);
	}

}
