package swiggyhotel.dao;


import swiggyhotel.dao.impl.DiscountDAOImpl;
import swiggyhotel.dao.impl.FoodItemsDAOImpl;
import swiggyhotel.dao.impl.MenusDAOImpl;
import swiggyhotel.dao.impl.OrderItemDAOImpl;
import swiggyhotel.dao.impl.OrdersDAOImpl;
import swiggyhotel.dao.impl.RatingDAOImpl;
import swiggyhotel.dao.impl.UsersDAOImpl;

public class DAOFactory {
	public static DiscountDAO getDiscountDAO()
	{
		DiscountDAO d=new DiscountDAOImpl();
		return d;
	}
	public static FoodItemsDAO getFoodItemsDAO()
	{
		FoodItemsDAO f=new FoodItemsDAOImpl();
		return f;
	}
	public static MenusDAO getMenusDAO()
	{
		MenusDAO m=new MenusDAOImpl();
		return m;
	}
	public static OrdersDAO getOrdersDAO()
	{
		OrdersDAO ob=new OrdersDAOImpl();
		return ob;
	}
	public static OrderItemDAO getOrderItemDAO()
	{
		OrderItemDAO obj=new OrderItemDAOImpl();
		return obj;
	}
	public static RatingDAO getRatingDAO()
	{
		RatingDAO r=new RatingDAOImpl();
		return r;
	}
	public static UsersDAO getUsersDAO()
	{
		UsersDAO u=new UsersDAOImpl();
		return u;
	}




}
