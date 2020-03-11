package swiggyhotel.service;

import swiggyhotel.Exception.ValidatorException;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrderItemValidationDAO;

public class OrderItemValidationService {
	private OrderItemValidationDAO orderItem = DAOFactory.getOrderItemValidationDAO();
	public boolean checkOrderId(int OrderId) throws ValidatorException
	{
		return orderItem.checkOrderId(OrderId);
		
	}
	public boolean checkItemId(int ItemId) throws ValidatorException
	{
		return orderItem.checkItemId(ItemId);
		
	}
	public boolean checkQuantity(int quantity) throws ValidatorException
	{
		return orderItem.checkQuantity(quantity);
		
	}
	public boolean checkTotalAmts(int TotalAmts) throws ValidatorException
	{
		return orderItem.checkTotalAmts(TotalAmts);
		
	}

}
