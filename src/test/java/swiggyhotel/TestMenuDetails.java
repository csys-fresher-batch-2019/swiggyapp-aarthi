package swiggyhotel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.dao.MenusDAO;
import swiggyhotel.model.FoodDetails;
import swiggyhotel.model.MenuDetails;
public class TestMenuDetails
{
	public static final LoggerUtil logger=LoggerUtil.getInstance();
    public static void main(String[] args) throws Exception 
     {
		MenusDAO obj=DAOFactory.getMenusDAO();
		Scanner s=new Scanner(System.in);
		logger.debug("1.FindAll\n2.GetCategory\n3.GetItemNameAndPrice\n4.GetFoods\n5.GetSnacksAndShakes\n6.GetDesserts\n");
		logger.debug("Enter the choice");
		int choice=s.nextInt();
	    switch(choice)
		{
		  case 1:List<MenuDetails> l=new ArrayList<MenuDetails>();
			     l=obj.findAll();
			     for (MenuDetails menuDetails : l)
			     {
				   logger.debug(menuDetails);
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
		         for(FoodDetails food : l1)
		          {
			        logger.debug(food.getItemId()+" "+food.getItemName()+" "+food.getFoodType()+" "+food.getPrice());
		          }
	             break;
		  case 5:List<FoodDetails> l2=new ArrayList<FoodDetails>();
	             l2=obj.getSnacksAndShakes();
	             for(FoodDetails snacks : l2) 
	              {
		            logger.debug(snacks.getItemId()+" "+snacks.getItemName()+" "+snacks.getFoodType()+" "+snacks.getPrice());
	              }
                 break;
		  case 6:List<FoodDetails> l3=new ArrayList<FoodDetails>();
                 l3=obj.getDesserts();
                 for (FoodDetails desserts : l3)
                  {
	               logger.debug(desserts.getItemId()+desserts.getItemName()+desserts.getFoodType()+desserts.getPrice());
                  }
                 break;
	     default:logger.debug("Invalid choice");
		         break;
	     }
	     s.close();
     }
}
