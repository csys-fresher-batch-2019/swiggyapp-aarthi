package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.model.FoodDetails;

public class TestFoodDetails {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		FoodItemsDAO ob=DAOFactory.getFoodItemsDAO();
		Scanner s=new Scanner(System.in);
		logger.debug("1.InsertFoods\n2.UpdateMenuId\n3.FindAll\n4.GetFoodDetails\n5.GetFoodsDetailsBySearchName\n");
		logger.debug("\nEnter the choice");
		int choice=s.nextInt();
		switch(choice)
		{
		    case 1:
		    	logger.debug("enter the itemId");
				int itemId=s.nextInt();
				s.nextLine();
				logger.debug("enter the itemName");
				String itemName=s.nextLine();
				logger.debug("enter the foodType");
				String foodType=s.next();
				s.nextLine();
				logger.debug("enter the price");
				int price=s.nextInt();
		    	ob.insertItems(itemId,itemName,foodType,price,"");
		    break;
		    case 2:
		    	logger.debug("enter the menuId");
				int menuId=s.nextInt();
				logger.debug("enter the itemName");
				String itemname=s.next();
			    ob.updateMenuId(menuId,itemname);
		    break;
		    case 3:List<FoodDetails> l=new ArrayList<FoodDetails>();
		           //FoodDetails ob=new FoodDetails();
		           l= ob.findAll();
		           for (FoodDetails foodDetails : l) {
					logger.debug(foodDetails.toString());
				}
		    break;
		        
		    case 4:
		    	logger.debug("enter the foodType(V/NV/O)");
			    String foodtype=s.next();
		    	ob.getFoodDetails(foodtype);
		    break;
		    case 5:List<FoodDetails> l1=new ArrayList<FoodDetails>();
	           //FoodDetails ob=new FoodDetails();
		         logger.debug("enter the searchname");
		         String searchName=s.next();
		         l1= ob.getFoodsDetailsBySearchName(searchName);
	             for (FoodDetails foodDetails : l1) {
				 logger.debug(foodDetails.toString());
			}
	    break;
		    
		    default:logger.debug("invalid choice");
		    break;
		}

}
}
