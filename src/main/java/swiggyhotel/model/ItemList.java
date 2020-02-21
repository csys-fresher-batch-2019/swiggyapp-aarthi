package swiggyhotel.model;

import java.time.LocalDateTime;

public class ItemList {
	public int orderId;
	public int itemId;
	public int quantity;
	public int totalAmount;
	public String status;
	public LocalDateTime orderedDate;
	
	@Override
	public String toString() {
		return "ItemList [orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity + ", totalAmount="
				+ totalAmount + ", status=" + status + ", orderedDate=" + orderedDate + "]";
	}
	

}
