package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrderItemDAO;
import swiggyhotel.model.OrderItemDetails;

public class TestOrderItemDetails {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		OrderItemDAO ob=DAOFactory.getOrderItemDAO();
		List<OrderItemDetails> l1=new ArrayList<OrderItemDetails>();
		Scanner s=new Scanner(System.in);
		logger.debug("1.findAll\n2.updateStatus\n");
		logger.debug("enter the choice");
		int choice=s.nextInt();
		switch(choice)
		{
		case 1: l1=ob.findAll();
		        for (OrderItemDetails orderItemDetails : l1) {
			     logger.debug(orderItemDetails.toString());
		        }
		        break;
	    case 2: logger.debug("enter the orderid");
		        int orderId=s.nextInt();
		        s.nextLine();
		        logger.debug("enter the comments");
		        String comments=s.nextLine();
		        ob.updateStatus(orderId,comments);
		        break;
		        default:logger.debug("Invalid choice");
		        break;
		
		
	}
	}
}


