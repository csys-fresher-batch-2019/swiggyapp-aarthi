package swiggyhotel.dao;

import java.util.List;

import swiggyhotel.model.RatingDetails;

public interface RatingDAO {
	public List<RatingDetails> findAll() throws Exception;
	public void insertRatings(RatingDetails ob) throws Exception;
	public void getRatings(String itemName) throws Exception;
	

}
