package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aarthi.swiggyhotel.model.FoodItem;
import com.aarthi.swiggyhotel.model.Menu;
import com.aarthi.swiggyhotel.service.MenuService;
import com.aarthi.swiggyhotel.util.LoggerUtil;


public class TestMenuDetails {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		MenuService service = new MenuService();
		Scanner s = new Scanner(System.in);
		logger.debug(
				"1.FindAll\n2.GetCategory\n3.GetItemNameAndPrice\n4.GetFoods\n5.GetSnacksAndShakes\n6.GetDesserts\n");
		logger.debug("Enter the choice");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			List<Menu> l = new ArrayList<Menu>();
			l = service.findAll();
			for (Menu menuDetails : l) {
				logger.debug(menuDetails);
			}
			break;
		case 2:
			List<Menu> list = service.getCategory();
			for (Menu menuDetails : list) {
				logger.debug(menuDetails);
			}
			break;
		case 3:
			logger.debug("enter the itemName");
			String itemName = s.next();
			List<FoodItem> l4 = service.getItemNameAndPrice(itemName);
			for (FoodItem foodDetails : l4) {
				logger.debug(foodDetails);
			}
			break;
		case 4:
			List<FoodItem> l1 = new ArrayList<FoodItem>();
			l1 = service.getFoods();
			for (FoodItem food : l1) {
				logger.debug(
						food.getItemId() + " " + food.getItemName() + " " + food.getFoodType() + " " + food.getPrice());
			}
			break;
		case 5:
			List<FoodItem> l2 = new ArrayList<FoodItem>();
			l2 = service.getSnacksAndShakes();
			for (FoodItem snacks : l2) {
				logger.debug(snacks.getItemId() + " " + snacks.getItemName() + " " + snacks.getFoodType() + " "
						+ snacks.getPrice());
			}
			break;
		case 6:
			List<FoodItem> l3 = new ArrayList<FoodItem>();
			l3 = service.getDesserts();
			for (FoodItem desserts : l3) {
				logger.debug(
						desserts.getItemId() + desserts.getItemName() + desserts.getFoodType() + desserts.getPrice());
			}
			break;
		default:
			logger.debug("Invalid choice");
			break;
		}
		s.close();
	}
}
