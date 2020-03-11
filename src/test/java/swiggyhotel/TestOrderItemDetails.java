package swiggyhotel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import swiggyhotel.exception.ValidatorException;
import swiggyhotel.logger.LoggerUtil;
import swiggyhotel.model.OrderItemDetails;
import swiggyhotel.service.OrderItemDetailsService;
import swiggyhotel.service.OrderItemValidationService;

public class TestOrderItemDetails {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		OrderItemDetailsService service = new OrderItemDetailsService();
		OrderItemDetails a = new OrderItemDetails();
		List<OrderItemDetails> l1 = new ArrayList<OrderItemDetails>();
		Scanner s = new Scanner(System.in);
		logger.debug("1.FindAll\n2.UpdateStatus\n3.Insertorderitems\n");
		logger.debug("Enter the choice");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			l1 = service.findAll();
			for (OrderItemDetails orderItemDetails : l1) {
				logger.debug(orderItemDetails);
			}
			break;
		case 2:
			logger.debug("Enter the orderid");
			int orderId = s.nextInt();
			s.nextLine();
			logger.debug("Enter the comments");
			String comments = s.nextLine();
			String value = service.updateStatus(orderId, comments);
			logger.debug(value);
			break;
		case 3:
			boolean orderId1 = true;
			boolean itemId = true;
			boolean quantity = true;
			boolean totalAmt = true;
			OrderItemValidationService orderItem = new OrderItemValidationService();
			logger.debug("Enter the orderid");
			int orderId3 = s.nextInt();
			a.setOrderId(orderId3);
			try {
				orderId1 = orderItem.checkOrderId(orderId3);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			logger.debug("Enter the itemid");
			int itemId3 = s.nextInt();
			a.setItemId(itemId3);
			try {
				itemId = orderItem.checkItemId(itemId3);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			logger.debug("Enter the quantity");
			int quantity1 = s.nextInt();
			a.setQuantity(s.nextInt());
			try {
				quantity = orderItem.checkQuantity(quantity1);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			logger.debug("Enter the totalamounts");
			int totalAmt2 = s.nextInt();
			a.setTotalAmounts(totalAmt2);
			try {
				totalAmt = orderItem.checkTotalAmts(totalAmt2);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			LocalDateTime orderTime = LocalDateTime.now();
			a.setOrderDate(orderTime);
			if (orderId1 == true || itemId == true || quantity == true || totalAmt == true) {
				int value1 = service.insertorderitems(a);
				logger.debug(value1);
			}
			break;
		default:
			logger.debug("Invalid choice");
			break;
		}
		s.close();
	}
}
