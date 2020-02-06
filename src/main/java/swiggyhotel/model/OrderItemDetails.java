package swiggyhotel.model;

import java.sql.Date;
import java.time.LocalDate;

public class OrderItemDetails {
	
	public int orderItemId;
	public int orderId;
	public int itemId;
	public int quantity;
	public int totalAmounts;
	public String status;
	public Date orderDate;
	@Override
	public String toString() {
		return "OrderItemDetails [orderItemId=" + orderItemId + ", orderId=" + orderId + ", itemId=" + itemId
				+ ", quantity=" + quantity + ", totalAmounts=" + totalAmounts + ", status=" + status + ", orderDate="
				+ orderDate + "]";
	}

}
