package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aarthi.swiggyhotel.exception.ValidatorException;
import com.aarthi.swiggyhotel.model.FoodItem;
import com.aarthi.swiggyhotel.service.FoodItemService;
import com.aarthi.swiggyhotel.service.MenuService;
import com.aarthi.swiggyhotel.util.LoggerUtil;
import com.aarthi.swiggyhotel.validator.FoodDetailValidator;



public class TestFoodDetails {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		FoodItemService food = new FoodItemService();
		MenuService menu = new MenuService();
		FoodDetailValidator ob = new FoodDetailValidator();
		Scanner s = new Scanner(System.in);
		logger.debug(
				"1.InsertFoods\n2.UpdateMenuId\n3.FindAll\n4.GetFoodDetails\n5.GetFoodsDetailsBySearchName\n6.deleteFoods\n");
		logger.debug("\nEnter the choice");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			boolean itemName = true;
			boolean foodType = true;
			boolean price = true;
			boolean menuId = true;
			logger.debug("Enter the itemName");
			String itemName1 = s.next();
			try {
				itemName = ob.checkFoodName(itemName1);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}

			logger.debug("Enter the foodType(V/NV/O)");
			String foodType1 = s.next();
			try {
				foodType = ob.checkFoodType(foodType1);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			s.nextLine();
			logger.debug("Enter the price");
			int price1 = s.nextInt();
			try {
				menuId = ob.checkPrice(price1);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}

			logger.debug("Enter the menuid");
			int menuId1 = s.nextInt();
			try {
				menuId = ob.checkMenuId(menuId1);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			logger.debug("Enter the images(.jpg)");
			String images = s.next();
			if (itemName == true || foodType == true || price == true || menuId == true) {
				int value = food.insertItems(itemName1, foodType1, price1, menuId1, images);
				logger.debug(value);
			}
			break;
		case 2:
			logger.debug("Enter the menuId");
			int menuId2 = s.nextInt();
			logger.debug("Enter the itemName");
			String itemName2 = s.next();
			int value1 = food.updateMenuId(menuId2, itemName2);
			logger.debug(value1);
			break;
		case 3:
			List<FoodItem> l = food.findAll();
			for (FoodItem foodDetails : l) {
				logger.debug(foodDetails);
			}
			break;
		case 4:
			logger.debug("Enter the foodType(V/NV/O)");
			List<FoodItem> l2 = new ArrayList<FoodItem>();
			String foodType2 = s.next();
			l2 = food.getFoodDetails(foodType2);
			for (FoodItem foodDetail : l2) {
				logger.debug(foodDetail.displayItem());
			}
			break;
		case 5:
			List<FoodItem> l1 = new ArrayList<FoodItem>();
			logger.debug("Enter the searchname");
			String searchName = s.next();
			String word = menu.toUpp(searchName);
			l1 = food.getFoodsDetailsBySearchName(word);
			for (FoodItem foodDetails : l1) {
				logger.debug(foodDetails.display());
			}
			break;
		case 6:
			logger.debug("Enter the itemname");
			String itemName3 = s.next();
			int value2 = food.deleteFoods(itemName3);
			logger.debug(value2);
			break;
		default:
			logger.debug("Invalid Choice");
			break;
		}
		s.close();
	}
}
