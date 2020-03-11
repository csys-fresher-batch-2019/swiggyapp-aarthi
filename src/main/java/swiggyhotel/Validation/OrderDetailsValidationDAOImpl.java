package swiggyhotel.Validation;

import swiggyhotel.Exception.ValidatorException;
import swiggyhotel.dao.OrdersValidationDAO;

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
