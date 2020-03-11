package swiggyhotel.service;

import java.util.HashMap;
import java.util.List;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.UsersDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.UserDetails;

public class UserDetailsService {
	private UsersDAO user = DAOFactory.getUsersDAO();

	public List<UserDetails> displayUserDetails() throws DbException {
		return user.findAll();
	}

	public HashMap<String, Integer> getNameAndTotalAmts(int orderId) throws DbException {
		return user.findByNameAndTotalAmt(orderId);

	}

	public int insertUserInfo(UserDetails ob) throws DbException {
		return user.save(ob);
	}

	public String login(String name, Long phoneno) throws DbException {
		return user.findByNameAndPhoneNo(name, phoneno);
	}

	public int getUserId(String name, Long phoneno) throws DbException {
		return user.findUserId(name, phoneno);
	}

	public String adminLogin(String userName, String passWord) throws DbException {
		return user.findByNameAndPassWord(userName, passWord);
	}

	public int getOrderId(int userId) throws DbException {
		return user.findOrderId(userId);
	}

	public int validNumber(Long PhoneNo) throws DbException {
		return user.ValidNumber(PhoneNo);

	}
}
