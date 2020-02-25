package swiggyhotel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrderItemDAO;
import swiggyhotel.model.OrderItemDetails;
public class TestOrderItemDetails
{
	public static final LoggerUtil logger=LoggerUtil.getInstance();
    public static void main(String[] args) throws Exception
     {
		OrderItemDAO ob=DAOFactory.getOrderItemDAO();
		OrderItemDetails a=new OrderItemDetails();
		List<OrderItemDetails> l1=new ArrayList<OrderItemDetails>();
		Scanner s=new Scanner(System.in);
		logger.debug("1.FindAll\n2.UpdateStatus\n3.Insertorderitems\n");
		logger.debug("Enter the choice");
		int choice=s.nextInt();
		switch(choice)
		{
		    case 1:l1=ob.findAll();
		           for (OrderItemDetails orderItemDetails : l1)
		             {
			            logger.debug(orderItemDetails);
		             }
		           break;
	        case 2:logger.debug("Enter the orderid");
		           int orderId=s.nextInt();
		           s.nextLine();
		           logger.debug("Enter the comments");
		           String comments=s.nextLine();
		           ob.updateStatus(orderId,comments);
		           break;
		    case 3:logger.debug("Enter the orderid");
                   a.setOrderId(s.nextInt());
                   logger.debug("Enter the itemid");
		           a.setItemId(s.nextInt());
		           logger.debug("Enter the quantity");
		           a.setQuantity(s.nextInt());
		           logger.debug("Enter the totalamounts");
		           a.setTotalAmounts(s.nextInt());
		           LocalDateTime orderTime  = LocalDateTime.now();
		           a.setOrderDate(orderTime);
		           ob.insertorderitems(a);
		           break;
	       default:logger.debug("Invalid choice");
                   break;
		}
	  s.close();
	}
}


