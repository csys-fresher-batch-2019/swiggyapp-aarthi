package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.DiscountDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.FoodDetails;
import swiggyhotel.model.ItemList;

public class TestDiscountDetails {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		DiscountDAO ob= DAOFactory.getDiscountDAO();
		Scanner s=new Scanner(System.in);
		logger.debug("1.calculateDiscountAmt\n2.updateDiscountAmt\n3.getItemList");
		logger.debug("enter the choice");
		int choice=s.nextInt();
		switch(choice)
		{
		case 1:logger.debug("enter the orderid");
		       int orderId=s.nextInt();
		       int amt=ob.calculateDiscountAmt(orderId);
		       logger.debug(amt);
               break;
		case 2:logger.debug("enter the orderid");
		       int orderId1=s.nextInt();
               ob.updateDiscountAmt(orderId1);
               break;
               default:logger.debug("Invalid choice");
               break;
        case 3:List<ItemList> l1=new ArrayList<ItemList>();
               logger.debug("enter the itemid");
               int orderId4=s.nextInt();
               l1= ob.getItemList(orderId4);
               
              
            	   logger.debug(l1);
			
       break;
	}

}
}
