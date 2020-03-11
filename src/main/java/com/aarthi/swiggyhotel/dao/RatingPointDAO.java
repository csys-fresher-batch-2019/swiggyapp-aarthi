package com.aarthi.swiggyhotel.dao;

import java.util.List;

import com.aarthi.swiggyhotel.exception.DbException;
import com.aarthi.swiggyhotel.model.RatingPoint;


public interface RatingPointDAO {
	public List<RatingPoint> findAll() throws DbException;

	public int save(RatingPoint ob) throws DbException;

	public List<RatingPoint> findByItemName(String itemName) throws DbException;

	public int findRate(String itemName) throws DbException;
}
