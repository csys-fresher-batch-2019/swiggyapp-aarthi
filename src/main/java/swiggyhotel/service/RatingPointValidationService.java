package swiggyhotel.service;

import swiggyhotel.Exception.ValidatorException;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.RatingPointsValidationDAO;

public class RatingPointValidationService {
	private RatingPointsValidationDAO rate = DAOFactory.getRatingPointsValidationDAO();
	public boolean checkUserId(int userId) throws ValidatorException
	{
		return rate.checkUserId(userId);
		
	}
	public boolean checkRatingPoints(int ratingPoint) throws ValidatorException
	{
		return rate.checkRatingPoints(ratingPoint);
		
	}
	public boolean checkItemId(int itemId) throws ValidatorException
	{
		return rate.checkItemId(itemId);
		
	}

}
