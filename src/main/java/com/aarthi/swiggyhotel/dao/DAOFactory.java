package com.aarthi.swiggyhotel.dao;

import com.aarthi.swiggyhotel.dao.Impl.DiscountDAOImpl;
import com.aarthi.swiggyhotel.dao.Impl.FoodItemDAOImpl;
import com.aarthi.swiggyhotel.dao.Impl.MenuDAOImpl;
import com.aarthi.swiggyhotel.dao.Impl.OrderDAOImpl;
import com.aarthi.swiggyhotel.dao.Impl.OrderItemDAOImpl;
import com.aarthi.swiggyhotel.dao.Impl.RatingPointDAOImpl;
import com.aarthi.swiggyhotel.dao.Impl.UserDAOImpl;

public class DAOFactory {
	public static DiscountDAO getDiscountDAO() {
		DiscountDAO d = new DiscountDAOImpl();
		return d;
	}

	public static FoodItemDAO getFoodItemDAO() {
		FoodItemDAO f = new FoodItemDAOImpl();
		return f;
	}

	public static MenuDAO getMenuDAO() {
		MenuDAO m = new MenuDAOImpl();
		return m;
	}

	public static OrderDAO getOrderDAO() {
		OrderDAO ob = new OrderDAOImpl();
		return ob;
	}

	public static OrderItemDAO getOrderItemDAO() {
		OrderItemDAO obj = new OrderItemDAOImpl();
		return obj;
	}

	public static RatingPointDAO getRatingPointDAO() {
		RatingPointDAO r = new RatingPointDAOImpl();
		return r;
	}

	public static UserDAO getUserDAO() {
		UserDAO u = new UserDAOImpl();
		return u;
	}

}
