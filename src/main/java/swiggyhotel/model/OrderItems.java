package swiggyhotel.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderItems {
	private int orderId;
	private int userId;
	private LocalDateTime orderedDate;
	private LocalDate deliveredDate;
	private LocalDateTime approxDeliveryTime;
	private int totalAmts;
	private String statusInfo;
	private String comments;
	private int afterDiscount;
	private int orderItemId;
	private int itemId;
	private int quantity;
	private int totalAmounts;
	private String status;
	private LocalDateTime orderDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	public LocalDate getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDate deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public LocalDateTime getApproxDeliveryTime() {
		return approxDeliveryTime;
	}

	public void setApproxDeliveryTime(LocalDateTime approxDeliveryTime) {
		this.approxDeliveryTime = approxDeliveryTime;
	}

	public int getTotalAmts() {
		return totalAmts;
	}

	public void setTotalAmts(int totalAmts) {
		this.totalAmts = totalAmts;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getAfterDiscount() {
		return afterDiscount;
	}

	public void setAfterDiscount(int afterDiscount) {
		this.afterDiscount = afterDiscount;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
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

}
