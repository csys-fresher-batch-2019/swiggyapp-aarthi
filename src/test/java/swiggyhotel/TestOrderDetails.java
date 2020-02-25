package swiggyhotel;
import java.time.LocalDateTime;
import java.util.Scanner;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrdersDAO;
import swiggyhotel.model.OrderDetails;
public class TestOrderDetails
{
	public static final LoggerUtil logger=LoggerUtil.getInstance();
    public static void main(String[] args) throws Exception
     {
		OrdersDAO ob=DAOFactory.getOrdersDAO();
		OrderDetails obj=new OrderDetails();
		Scanner s=new Scanner(System.in);
		logger.debug("1.InsertOrders\n2.CalculateTotalAmts\n3.UpdateTotalAmts\n4.UpdateDeliveredDateAndStatus\n");
		logger.debug("Enter the choice");
		int choice=s.nextInt();
		switch(choice)
		{
		   case 1:logger.debug("Enter the userid");
		          obj.setUserId(s.nextInt());
		          LocalDateTime orderTime  = LocalDateTime.now();
		          LocalDateTime approxDeliveryTime = orderTime.plusHours(1);
		          obj.setOrderedDate(orderTime);
		          obj.setApproxDeliveryTime(approxDeliveryTime); 
		          ob.insertOrders(obj);
		          break;
		   case 2:logger.debug("Enter the orderid");
		    	  int orderId1=s.nextInt();
	              int amt=ob.calculateTotalAmts(orderId1);
	              logger.debug(amt);
	              break;
		   case 3:logger.debug("Enter the orderid");
		    	  int orderId2=s.nextInt();
		    	  ob.updateTotalAmts(orderId2);
		    	  break;
		   case 4:logger.debug("Enter the orderid");
	    	      int orderId=s.nextInt();
	              ob.updateDeliveredDateAndStatus(orderId);
	              break;
		  default:logger.debug("Invalid choice");
		    	  break;
		 }
	   s.close();
	}
 }