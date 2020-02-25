package swiggyhotel.dao;
import java.util.List;
import swiggyhotel.model.DbException;
import swiggyhotel.model.RatingDetails;
public interface RatingDAO
 {
	public List<RatingDetails> findAll() throws DbException;
	public void insertRatings(RatingDetails ob) throws DbException;
	public List<RatingDetails>  getRatings(String itemName) throws DbException;
	public int getItemRatings(String itemName) throws DbException;
 }
