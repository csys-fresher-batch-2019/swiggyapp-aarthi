package swiggyhotel.dao;

import swiggyhotel.Exception.ValidatorException;

public interface RatingPointsValidationDAO {
	public boolean checkUserId(int userId) throws ValidatorException;

	public boolean checkRatingPoints(int ratingPoint) throws ValidatorException;

	public boolean checkItemId(int itemId) throws ValidatorException;

}