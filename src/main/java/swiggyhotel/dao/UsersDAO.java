package swiggyhotel.dao;

import java.util.HashMap;
import java.util.List;

//import swiggyhotel.ConnectionUtil;
import swiggyhotel.model.UserDetails;

public interface UsersDAO {
	public List<UserDetails> displayUserDetails() throws Exception;
	public HashMap<String, Integer> getNameAndtotalAmts(int orderId) throws Exception;
	//public List<String> getNames(String city) throws Exception;
	public void insertUserInfo(UserDetails ob)throws Exception;
	public String login(String name,Long phoneno)throws Exception;
     
}
	