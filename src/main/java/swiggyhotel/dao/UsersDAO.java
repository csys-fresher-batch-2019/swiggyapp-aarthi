package swiggyhotel.dao;
import java.util.HashMap;
import java.util.List;
import swiggyhotel.model.DbException;
import swiggyhotel.model.UserDetails;
public interface UsersDAO
 {
	public List<UserDetails> displayUserDetails() throws DbException;
	public HashMap<String, Integer> getNameAndTotalAmts(int orderId) throws DbException;
	public void insertUserInfo(UserDetails ob)throws DbException;
	public String login(String name,Long phoneno)throws DbException;
	public int getUserId(String name,Long phoneno)throws DbException;
	public String adminLogin(String userName,String passWord)throws DbException;
	public int getOrderId(int userId)throws DbException;
 }
	