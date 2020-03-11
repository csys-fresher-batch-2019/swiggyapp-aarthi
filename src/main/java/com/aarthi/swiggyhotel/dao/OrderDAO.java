package com.aarthi.swiggyhotel.dao;

import com.aarthi.swiggyhotel.exception.DbException;
import com.aarthi.swiggyhotel.model.Order;


public interface OrderDAO {
	public int updateDeliveredDateAndStatus(int orderId) throws DbException;

	public int findTotalAmt(int orderId) throws DbException;

	public int updateTotalAmt(int orderId) throws DbException;

	public int save(Order ob) throws DbException;

	public int updateDeliveredDate(int orderId) throws DbException;
}
