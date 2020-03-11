package com.aarthi.swiggyhotel.dao;

import java.util.List;

import com.aarthi.swiggyhotel.dto.Item;
import com.aarthi.swiggyhotel.exception.DbException;

public interface DiscountDAO {

	public int findDiscount(int orderId) throws DbException;

	public int updateDiscount(int orderId) throws DbException;

	public List<Item> findByOrderId(int orderId) throws DbException;

	public String findItemName(int itemId) throws DbException;
}
