package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aarthi.swiggyhotel.dto.Item;
import com.aarthi.swiggyhotel.service.DiscountService;
import com.aarthi.swiggyhotel.util.LoggerUtil;


public class TestDiscountDetails {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		DiscountService service = new DiscountService();
		Scanner s = new Scanner(System.in);
		logger.debug("1.CalculateDiscountAmt\n2.UpdateDiscountAmt\n3.GetItemList\n4.GetItemNames\n");
		logger.debug("Enter the choice");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			logger.debug("Enter the orderid");
			int orderId = s.nextInt();
			int amt = service.calculateDiscountAmt(orderId);
			logger.debug(amt);
			break;
		case 2:
			logger.debug("Enter the orderid");
			int orderId1 = s.nextInt();
			int value = service.updateDiscountAmt(orderId1);
			logger.debug(value);
			break;
		case 3:
			List<Item> l1 = new ArrayList<Item>();
			logger.debug("Enter the itemid");
			int orderId4 = s.nextInt();
			l1 = service.getItemList(orderId4);
			logger.debug(l1);
			break;
		case 4:
			logger.debug("Enter the itemid");
			int itemId = s.nextInt();
			String name = service.getItemName(itemId);
			logger.debug(name);
			break;
		default:
			logger.debug("Invalid Choice");
			break;
		}
		s.close();
	}
}
