package swiggyhotel.dao;

import java.util.List;

import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.ItemList;

public interface DiscountDAO {

	public int findDiscount(int orderId) throws DbException;

	public int updateDiscount(int orderId) throws DbException;

	public List<ItemList> findByOrderId(int orderId) throws DbException;

	public String findItemName(int itemId) throws DbException;
}
