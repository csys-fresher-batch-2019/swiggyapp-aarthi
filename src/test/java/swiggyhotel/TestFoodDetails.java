package swiggyhotel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.model.FoodDetails;
public class TestFoodDetails
{
	public static final LoggerUtil logger=LoggerUtil.getInstance();
    public static void main(String[] args) throws Exception 
     {
		FoodItemsDAO ob=DAOFactory.getFoodItemsDAO();
		Scanner s=new Scanner(System.in);
		logger.debug("1.InsertFoods\n2.UpdateMenuId\n3.FindAll\n4.GetFoodDetails\n5.GetFoodsDetailsBySearchName\n6.deleteFoods\n");
		logger.debug("\nEnter the choice");
		int choice=s.nextInt();
		switch(choice)
		{
		    case 1:logger.debug("Enter the itemName");
				   String itemName=s.next();
				   logger.debug("Enter the foodType");
				   String foodType=s.next();
				   s.nextLine();
				   logger.debug("Enter the price");
				   int price=s.nextInt();
				   logger.debug("Enter the menuid");
				   int menuId=s.nextInt();
				   logger.debug("Enter the images");
				   String images=s.next();
		    	   ob.insertItems(itemName,foodType,price,menuId,images);
		           break;
		    case 2:logger.debug("Enter the menuId");
				   int menuId1=s.nextInt();
				   logger.debug("Enter the itemName");
				   String itemName1=s.next();
			       ob.updateMenuId(menuId1,itemName1);
		           break;
		    case 3:List<FoodDetails> l=ob.findAll();
		           //l= ob.findAll();
		           for(FoodDetails foodDetails : l)
		           {
					  logger.debug(foodDetails);
				   }
		           break;
		    case 4:logger.debug("Enter the foodType(V/NV/O)");
			       String foodType1=s.next();
		    	   ob.getFoodDetails(foodType1);
		           break;
		    case 5:List<FoodDetails> l1=new ArrayList<FoodDetails>();
	               logger.debug("Enter the searchname");
		           String searchName=s.next();
		           l1= ob.getFoodsDetailsBySearchName(searchName);
	               for(FoodDetails foodDetails : l1) 
	               {
				       logger.debug(foodDetails);
			       }
	               break;
		    case 6:logger.debug("Enter the itemname");
			       String itemName2=s.next();
		    	   ob.deleteFoods(itemName2);
		           break;
		   default:logger.debug("Invalid Choice");
		            break;
		 }
         s.close();
     }
}
