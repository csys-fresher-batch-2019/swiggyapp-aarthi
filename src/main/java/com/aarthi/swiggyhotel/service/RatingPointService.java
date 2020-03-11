package com.aarthi.swiggyhotel.service;

import java.util.List;

import com.aarthi.swiggyhotel.dao.DAOFactory;
import com.aarthi.swiggyhotel.dao.RatingPointDAO;
import com.aarthi.swiggyhotel.exception.DbException;
import com.aarthi.swiggyhotel.model.RatingPoint;


public class RatingPointService {
	private RatingPointDAO rate = DAOFactory.getRatingPointDAO();

	public List<RatingPoint> findAll() throws DbException {
		return rate.findAll();
	}

	public int insertRatings(RatingPoint ob) throws DbException {
		return rate.save(ob);
	}

	public List<RatingPoint> getRatings(String itemName) throws DbException {
		return rate.findByItemName(itemName);
	}

	public int getItemRatings(String itemName) throws DbException {
		return rate.findRate(itemName);
	}
}
