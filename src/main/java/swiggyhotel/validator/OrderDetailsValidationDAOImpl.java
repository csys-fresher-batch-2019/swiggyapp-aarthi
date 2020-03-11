package swiggyhotel.validator;

import swiggyhotel.dao.OrdersValidationDAO;
import swiggyhotel.exception.ValidatorException;

public class OrderDetailsValidationDAOImpl implements OrdersValidationDAO {
	boolean msg = true;

	public boolean checkUserId(int userId) throws ValidatorException {

		if (userId > 0) {
			msg = true;
		} else {
			throw new ValidatorException("Negative Value is not allowed");
		}
		if (msg = true) {
			return true;
		} else {
			return false;
		}
	}

}
