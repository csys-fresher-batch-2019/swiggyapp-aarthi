package swiggyhotel;

import java.time.LocalDateTime;
import java.util.Scanner;

import swiggyhotel.Exception.ValidatorException;
import swiggyhotel.logger.LoggerUtil;
import swiggyhotel.model.OrderDetails;
import swiggyhotel.service.OrderValidationService;
import swiggyhotel.service.OrdersService;

public class TestOrderDetails {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		OrdersService service = new OrdersService();
		OrderDetails obj = new OrderDetails();
		Scanner s = new Scanner(System.in);
		logger.debug("1.InsertOrders\n2.CalculateTotalAmts\n3.UpdateTotalAmts\n4.UpdateDeliveredDateAndStatus\n");
		logger.debug("Enter the choice");
		int choice = s.nextInt();
		switch (choice) {
		case 1: OrderValidationService order=new  OrderValidationService();
	     	boolean  userId=true;
			logger.debug("Enter the userid");
			int userId1=s.nextInt();
			obj.setUserId(userId1);
			try
			   {
				 userId=order.checkUserId(userId1); 
			   }
			   catch(ValidatorException e)
			   {
				   logger.error(e.getMessage());
			   }
			LocalDateTime orderTime = LocalDateTime.now();
			LocalDateTime approxDeliveryTime = orderTime.plusHours(1);
			obj.setOrderedDate(orderTime);
			obj.setApproxDeliveryTime(approxDeliveryTime);
			if(userId==true) {
			int value = service.insertOrders(obj);
			logger.debug(value);
			}
			break;
		case 2:
			logger.debug("Enter the orderid");
			int orderId1 = s.nextInt();
			int amt = service.calculateTotalAmts(orderId1);
			logger.debug(amt);
			break;
		case 3:
			logger.debug("Enter the orderid");
			int orderId2 = s.nextInt();
			int value2 = service.updateTotalAmts(orderId2);
			logger.debug(value2);
			break;
		case 4:
			logger.debug("Enter the orderid");
			int orderId = s.nextInt();
			int value3 = service.updateDeliveredDateAndStatus(orderId);
			logger.debug(value3);
			break;
		default:
			logger.debug("Invalid choice");
			break;
		}
		s.close();
	}
}