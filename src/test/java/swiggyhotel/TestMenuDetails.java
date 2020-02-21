package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.dao.MenusDAO;
import swiggyhotel.model.FoodDetails;
import swiggyhotel.model.MenuDetails;

public class TestMenuDetails {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		MenusDAO obj=DAOFactory.getMenusDAO();
		//FoodItemsDAO ob=DAOFactory.getFoodItemsDAO();
		Scanner s=new Scanner(System.in);
		logger.debug("1.FindAll\n2.getCategory\n3.getItemNameAndPrice\n4.getFoods\n5.getSnacksAndShakes\n6.getDesserts\n");
		logger.debug("enter the choice");
		int choice=s.nextInt();
		//obj.FindAll();
		switch(choice)
		{
		case 1:List<MenuDetails> l=new ArrayList<MenuDetails>();
			   l=obj.FindAll();
			   for (MenuDetails menuDetails : l) {
				logger.debug(menuDetails.toString());
			}
		       break;
		case 2:obj.getCategory();
		       break;
		case 3:logger.debug("enter the itemName");
			   String itemName=s.next();
			   obj.getItemNameAndPrice(itemName);
			   break;
		case 4:List<FoodDetails> l1=new ArrayList<FoodDetails>();
		       l1=obj.getFoods();
		       for (FoodDetails food : l1) {
			   logger.debug(food.itemId+food.itemName+food.foodType+food.price);
		       }
	           break;
		case 5:List<FoodDetails> l2=new ArrayList<FoodDetails>();
	           l2=obj.getSnacksAndShakes();
	           for (FoodDetails snacks : l2) {
		       logger.debug(snacks.itemId+snacks.itemName+snacks.foodType+snacks.price);
	           }
               break;
		case 6:List<FoodDetails> l3=new ArrayList<FoodDetails>();
               l3=obj.getDesserts();
               for (FoodDetails desserts : l3) {
	           logger.debug(desserts.itemId+desserts.itemName+desserts.foodType+desserts.price);
               }
               break;
		 default:logger.debug("Invalid choice");
		       break;
	}
		}
}
