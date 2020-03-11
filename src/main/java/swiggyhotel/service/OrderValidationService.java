package swiggyhotel.service;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrdersValidationDAO;
import swiggyhotel.exception.ValidatorException;

public class OrderValidationService {
	private OrdersValidationDAO order = DAOFactory.getOrdersValidationDAO();

	public boolean checkUserId(int userId) throws ValidatorException {
		return order.checkUserId(userId);

	}

}
