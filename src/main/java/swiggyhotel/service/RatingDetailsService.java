package swiggyhotel.service;

import java.util.List;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.RatingDAO;
import swiggyhotel.dbexception.DbException;
import swiggyhotel.model.RatingDetails;

public class RatingDetailsService {
	private RatingDAO rate = DAOFactory.getRatingDAO();

	public List<RatingDetails> findAll() throws DbException {
		return rate.findAll();
	}

	public int insertRatings(RatingDetails ob) throws DbException {
		return rate.save(ob);
	}

	public List<RatingDetails> getRatings(String itemName) throws DbException {
		return rate.findByItemName(itemName);
	}

	public int getItemRatings(String itemName) throws DbException {
		return rate.findRate(itemName);
	}
}
