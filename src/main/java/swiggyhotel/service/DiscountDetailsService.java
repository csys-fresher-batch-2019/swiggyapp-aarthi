package swiggyhotel.service;

import java.util.List;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.DiscountDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.ItemList;

public class DiscountDetailsService {
	private DiscountDAO discount = DAOFactory.getDiscountDAO();

	public int calculateDiscountAmt(int orderId) throws DbException {
		return discount.findDiscount(orderId);

	}

	public int updateDiscountAmt(int orderId) throws DbException {
		return discount.updateDiscount(orderId);
	}

	public List<ItemList> getItemList(int orderId) throws DbException {
		return discount.findByOrderId(orderId);
	}

	public String getItemName(int itemId) throws DbException {
		return discount.findItemName(itemId);

	}

}
