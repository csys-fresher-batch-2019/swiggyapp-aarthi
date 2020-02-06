package swiggyhotel.dao;

//import java.util.ArrayList;

import swiggyhotel.model.DiscountDetails;

public interface DiscountDAO {
  
	public int calculateDiscountAmt(int orderId) throws Exception;
	public void updateDiscountAmt(int orderId) throws Exception;
}
