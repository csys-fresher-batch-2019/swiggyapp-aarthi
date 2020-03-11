package swiggyhotel.service;

import swiggyhotel.Exception.ValidatorException;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.RegisterFormValidationDAO;
import swiggyhotel.dbexception.DbException;

public class RegisterFormValidationService {
	private RegisterFormValidationDAO register=DAOFactory.getRegisterFormValidationDAO();
	public boolean checkName(String name) throws ValidatorException
	{
		return register.checkName(name);
		
	}
	public boolean checkPhoneNo(Long phoneno) throws ValidatorException, DbException
	{
		return register.checkPhoneNo(phoneno);
		
	}
	public boolean checkUserName(String username) throws ValidatorException
	{
		return register.checkUserName(username);
		
	}
	public boolean checkPassWord(String password) throws ValidatorException
	{
		return register.checkPassWord(password);
		
	}

}
