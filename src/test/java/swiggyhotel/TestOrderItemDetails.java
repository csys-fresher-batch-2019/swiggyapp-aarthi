package swiggyhotel;

import java.time.LocalDateTime;
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
		OrderItemDetails a=new OrderItemDetails();
		List<OrderItemDetails> l1=new ArrayList<OrderItemDetails>();
		Scanner s=new Scanner(System.in);
		logger.debug("1.findAll\n2.updateStatus\n3.insertorderitems\n");
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
	    case 3: logger.debug("enter the orderid");
                a.orderId=s.nextInt();
                logger.debug("enter the itemid");
		        a.itemId=s.nextInt();
		        logger.debug("enter the quantity");
		        a.quantity=s.nextInt();
		        logger.debug("enter the totalamounts");
		        a.totalAmounts=s.nextInt();
		        LocalDateTime orderTime  = LocalDateTime.now();
		        a.orderDate=orderTime;
		        ob.insertorderitems(a);
		        break;
		
		
	}
	}
}


