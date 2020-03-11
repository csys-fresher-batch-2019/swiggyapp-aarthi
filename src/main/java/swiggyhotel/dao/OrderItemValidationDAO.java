package swiggyhotel.dao;

import swiggyhotel.Exception.ValidatorException;

public interface OrderItemValidationDAO {
	public boolean checkOrderId(int OrderId) throws ValidatorException;

	public boolean checkItemId(int ItemId) throws ValidatorException;

	public boolean checkQuantity(int quantity) throws ValidatorException;

	public boolean checkTotalAmts(int TotalAmts) throws ValidatorException;

}
