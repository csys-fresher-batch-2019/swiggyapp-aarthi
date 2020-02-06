package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.MenusDAO;
import swiggyhotel.model.MenuDetails;

public class TestMenuDetails {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		MenusDAO obj=DAOFactory.getMenusDAO();
		Scanner s=new Scanner(System.in);
		logger.debug("1.FindAll\n2.getCategory\n3.getItemNameAndPrice\n");
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
		 default:logger.debug("Invalid choice");
		       break;
	}
		}
}
