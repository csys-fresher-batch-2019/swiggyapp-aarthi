package swiggyhotel.dao;

import swiggyhotel.Exception.ValidatorException;

public interface OrdersValidationDAO {
	public boolean checkUserId(int userId) throws ValidatorException;

}
