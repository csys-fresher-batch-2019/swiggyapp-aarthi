package swiggyhotel.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderItems {
	public int orderId;
	public int userId;
    public LocalDateTime orderedDate;
	public LocalDate deliveredDate;
	public LocalDateTime approxDeliveryTime;
	public int totalAmts;
	public String statusInfo;
	public String comments;
	public int afterDiscount;
	public int orderItemId;
    public int itemId;
	public int quantity;
	public int totalAmounts;
	public String status;
	public LocalDateTime orderDate;
}
