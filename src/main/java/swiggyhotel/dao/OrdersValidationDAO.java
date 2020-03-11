package swiggyhotel.dao;

import swiggyhotel.exception.ValidatorException;

public interface OrdersValidationDAO {
	public boolean checkUserId(int userId) throws ValidatorException;

}
