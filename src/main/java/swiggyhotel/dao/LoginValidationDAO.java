package swiggyhotel.dao;

import swiggyhotel.Exception.ValidatorException;

public interface LoginValidationDAO {
	public boolean checkName(String name) throws ValidatorException;

	public boolean checkPhoneNo(Long phoneno) throws ValidatorException;

}
