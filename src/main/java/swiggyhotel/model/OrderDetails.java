package swiggyhotel.model;

import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderDetails {
	public int orderId;
	public int userId;
    public LocalDateTime orderedDate;
	public LocalDate deliveredDate;
	public LocalDateTime approxDeliveryTime;
	public int totalAmts;
	public String statusInfo;
	public String comments;
	public int afterDiscount;
	
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", userId=" + userId + ", orderedDate=" + orderedDate
				+ ", deliveredDate=" + deliveredDate + ", totalAmts=" + totalAmts + ", statusInfo=" + statusInfo
				+ ", comments=" + comments + ", afterDiscount=" + afterDiscount + "]";
	}

}
