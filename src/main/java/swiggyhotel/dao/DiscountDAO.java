package swiggyhotel.dao;
import java.util.List;
import swiggyhotel.model.DbException;
import swiggyhotel.model.ItemList;
public interface DiscountDAO 
  {
    public int calculateDiscountAmt(int orderId) throws DbException;
	public void updateDiscountAmt(int orderId) throws DbException;
	public List<ItemList> getItemList(int orderId) throws DbException;
	public String getItemName(int itemId)throws DbException;
  }
