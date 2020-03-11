package com.aarthi.swiggyhotel.dao;

import java.util.List;

import com.aarthi.swiggyhotel.exception.DbException;
import com.aarthi.swiggyhotel.model.OrderItem;


public interface OrderItemDAO {
	public List<OrderItem> findAll() throws DbException;

	public String updateStatus(int orderId, String comments) throws DbException;

	public int save(OrderItem ab) throws DbException;
}
