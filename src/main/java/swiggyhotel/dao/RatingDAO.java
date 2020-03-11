package swiggyhotel.dao;

import java.util.List;

import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.RatingDetails;

public interface RatingDAO {
	public List<RatingDetails> findAll() throws DbException;

	public int save(RatingDetails ob) throws DbException;

	public List<RatingDetails> findByItemName(String itemName) throws DbException;

	public int findRate(String itemName) throws DbException;
}
