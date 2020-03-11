package com.aarthi.swiggyhotel.validator;

import com.aarthi.swiggyhotel.exception.ValidatorException;

public class RatingPointDetailValidator {
	boolean msg = true;

	public boolean checkUserId(int userId) throws ValidatorException {

		if (userId > 0) {
			msg = true;
		} else {
			throw new ValidatorException("Negative Value is not allowed");
		}
		if (msg = true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkRatingPoints(int ratingPoint) throws ValidatorException {

		if (ratingPoint == 1 || ratingPoint == 2 || ratingPoint == 3 || ratingPoint == 4 || ratingPoint == 5) {
			msg = true;
		} else if (ratingPoint < 0) {
			throw new ValidatorException("Negative value is not allowed");
		} else {
			throw new ValidatorException("Invalid RatingPoint");
		}
		if (msg = true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkItemId(int itemId) throws ValidatorException {

		if (itemId > 0) {
			msg = true;
		} else {
			throw new ValidatorException("Negative Value is not allowed");
		}
		if (msg = true) {
			return true;
		} else {
			return false;
		}
	}

}
