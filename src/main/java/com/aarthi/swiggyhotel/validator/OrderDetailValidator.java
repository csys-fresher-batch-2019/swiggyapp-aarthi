package com.aarthi.swiggyhotel.validator;

import com.aarthi.swiggyhotel.exception.ValidatorException;

public class OrderDetailValidator {
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

}
