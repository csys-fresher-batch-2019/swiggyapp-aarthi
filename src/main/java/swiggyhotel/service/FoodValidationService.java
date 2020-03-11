package swiggyhotel.service;


import swiggyhotel.Exception.ValidatorException;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.FoodValidationDAO;

public class FoodValidationService {
	private FoodValidationDAO food = DAOFactory.getFoodValidationDAO();
	public boolean checkPrice(int price) throws ValidatorException
	{
		return food.checkPrice(price);
	}
	public boolean checkFoodName(String itemName) throws ValidatorException
	{
		return food.checkFoodName(itemName);
		
	}
	public boolean checkFoodType(String foodType) throws ValidatorException
	{
		return food.checkFoodType(foodType);
		
	}
	public boolean checkMenuId(int menuId) throws ValidatorException
	{
		return food.checkMenuId(menuId);
		
	}
}
