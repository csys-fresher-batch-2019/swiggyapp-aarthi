package swiggyhotel.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderItemDetails {
	private int orderItemId;
	private int orderId;
	private int itemId;
	private int quantity;
	private int totalAmounts;
	private String status;
	private LocalDateTime orderDate;
	
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalAmounts() {
		return totalAmounts;
	}
	public void setTotalAmounts(int totalAmounts) {
		this.totalAmounts = totalAmounts;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "OrderItemDetails [orderItemId=" + orderItemId + ", orderId=" + orderId + ", itemId=" + itemId
				+ ", quantity=" + quantity + ", totalAmounts=" + totalAmounts + ", status=" + status + ", orderDate="
				+ orderDate + "]";
	}

}
