package swiggyhotel.service;

import swiggyhotel.Exception.ValidatorException;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrdersValidationDAO;

public class OrderValidationService {
	private OrdersValidationDAO order = DAOFactory.getOrdersValidationDAO();
	public boolean checkUserId(int userId) throws ValidatorException
	{
		return order.checkUserId(userId);
		
	}

}
