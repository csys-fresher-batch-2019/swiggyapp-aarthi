package swiggyhotel.dao;

import java.util.HashMap;
import java.util.List;

import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.UserDetails;

public interface UsersDAO {
	public List<UserDetails> findAll() throws DbException;

	public HashMap<String, Integer> findByNameAndTotalAmt(int orderId) throws DbException;

	public int save(UserDetails ob) throws DbException;

	public String findByNameAndPhoneNo(String name, Long phoneno) throws DbException;

	public int findUserId(String name, Long phoneno) throws DbException;

	public String findByNameAndPassWord(String userName, String passWord) throws DbException;

	public int findOrderId(int userId) throws DbException;

	public int ValidNumber(Long phoneNo) throws DbException;
}
