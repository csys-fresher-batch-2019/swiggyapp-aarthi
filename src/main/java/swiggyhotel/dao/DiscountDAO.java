package swiggyhotel.dao;

import swiggyhotel.model.DbException;

//import java.util.ArrayList;

import swiggyhotel.model.DiscountDetails;

public interface DiscountDAO {
  
	public int calculateDiscountAmt(int orderId) throws DbException;
	public void updateDiscountAmt(int orderId) throws DbException;
}
