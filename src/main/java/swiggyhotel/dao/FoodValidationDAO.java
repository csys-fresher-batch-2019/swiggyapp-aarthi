package swiggyhotel.dao;

import swiggyhotel.Exception.ValidatorException;

public interface FoodValidationDAO {
	public boolean checkPrice(int price) throws ValidatorException;

	public boolean checkFoodName(String itemName) throws ValidatorException;

	public boolean checkFoodType(String foodType) throws ValidatorException;

	public boolean checkMenuId(int menuId) throws ValidatorException;

}
