package swiggyhotel.dao;

import swiggyhotel.dao.impl.DiscountDAOImpl;
import swiggyhotel.dao.impl.FoodItemsDAOImpl;
import swiggyhotel.dao.impl.MenusDAOImpl;
import swiggyhotel.dao.impl.OrderItemDAOImpl;
import swiggyhotel.dao.impl.OrdersDAOImpl;
import swiggyhotel.dao.impl.RatingDAOImpl;
import swiggyhotel.dao.impl.UsersDAOImpl;
import swiggyhotel.validator.FoodDetailsValidationDAOImpl;
import swiggyhotel.validator.LoginFormValidationDAOImpl;
import swiggyhotel.validator.OrderDetailsValidationDAOImpl;
import swiggyhotel.validator.OrderItemDetailsValidatorDAOImpl;
import swiggyhotel.validator.RatingDetailsValidationDAOImpl;
import swiggyhotel.validator.RegisterFormValidationDAOImpl;

public class DAOFactory {
	public static DiscountDAO getDiscountDAO() {
		DiscountDAO d = new DiscountDAOImpl();
		return d;
	}

	public static FoodItemsDAO getFoodItemsDAO() {
		FoodItemsDAO f = new FoodItemsDAOImpl();
		return f;
	}

	public static MenusDAO getMenusDAO() {
		MenusDAO m = new MenusDAOImpl();
		return m;
	}

	public static OrdersDAO getOrdersDAO() {
		OrdersDAO ob = new OrdersDAOImpl();
		return ob;
	}

	public static OrderItemDAO getOrderItemDAO() {
		OrderItemDAO obj = new OrderItemDAOImpl();
		return obj;
	}

	public static RatingDAO getRatingDAO() {
		RatingDAO r = new RatingDAOImpl();
		return r;
	}

	public static UsersDAO getUsersDAO() {
		UsersDAO u = new UsersDAOImpl();
		return u;
	}

	public static FoodValidationDAO getFoodValidationDAO() {
		FoodValidationDAO food = new FoodDetailsValidationDAOImpl();
		return food;
	}

	public static LoginValidationDAO getLoginValidationDAO() {
		LoginValidationDAO login = new LoginFormValidationDAOImpl();
		return login;
	}

	public static OrderItemValidationDAO getOrderItemValidationDAO() {
		OrderItemValidationDAO orderItem = new OrderItemDetailsValidatorDAOImpl();
		return orderItem;
	}

	public static OrdersValidationDAO getOrdersValidationDAO() {
		OrdersValidationDAO order = new OrderDetailsValidationDAOImpl();
		return order;
	}

	public static RatingPointsValidationDAO getRatingPointsValidationDAO() {
		RatingPointsValidationDAO rate = new RatingDetailsValidationDAOImpl();
		return rate;
	}

	public static RegisterFormValidationDAO getRegisterFormValidationDAO() {
		RegisterFormValidationDAO register = new RegisterFormValidationDAOImpl();
		return register;
	}
}
