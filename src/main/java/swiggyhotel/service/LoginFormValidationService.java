package swiggyhotel.service;

import swiggyhotel.Exception.ValidatorException;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.LoginValidationDAO;

public class LoginFormValidationService {
	private LoginValidationDAO login = DAOFactory.getLoginValidationDAO();
	public boolean checkName(String name) throws ValidatorException
	{
		return login.checkName(name);
		
	}
	public boolean checkPhoneNo(Long phoneno) throws ValidatorException
	{
		return login.checkPhoneNo(phoneno);
		
	}
}
