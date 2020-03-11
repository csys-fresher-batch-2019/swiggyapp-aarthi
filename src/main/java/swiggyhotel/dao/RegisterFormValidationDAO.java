package swiggyhotel.dao;

import swiggyhotel.dbexception.DbException;
import swiggyhotel.exception.ValidatorException;

public interface RegisterFormValidationDAO {
	public boolean checkName(String name) throws ValidatorException;

	public boolean checkPhoneNo(Long phoneno) throws ValidatorException, DbException;

	public boolean checkUserName(String username) throws ValidatorException;

	public boolean checkPassWord(String password) throws ValidatorException;

}
