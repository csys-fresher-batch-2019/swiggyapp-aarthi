package swiggyhotel;

import java.time.LocalDateTime;
import java.util.Scanner;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrdersDAO;
import swiggyhotel.model.OrderDetails;

public class TestOrderDetails {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		/* String date = "2020-01-01";
        LocalDate d = LocalDate.parse(date);
        String date1="2019-01-02";
        LocalDate d1 = LocalDate.parse(date1);
        System.out.println("enter the orderid");
	    obj.orderId=s.nextInt();*/
      //  ob.insertOrders(37,25,d,d1,340,"ordered","successfully delivered",300);
		
		OrdersDAO ob=DAOFactory.getOrdersDAO();
		OrderDetails obj=new OrderDetails();
		Scanner s=new Scanner(System.in);
		logger.debug("1.insertOrders\n2.calculateTotalAmts\n3.updateTotalAmts\n4.updateDeliveredDateAndStatus\n");
		logger.debug("enter the choice");
		int choice=s.nextInt();
		switch(choice)
		{
		    case 1:
		    	   logger.debug("enter the orderid");
		           obj.orderId=s.nextInt();
		           logger.debug("enter the userid");
		           obj.userId=s.nextInt();
		           //logger.debug("enter the ordereddate");
		           LocalDateTime orderTime  = LocalDateTime.now();
		           LocalDateTime approxDeliveryTime = orderTime.plusHours(1);
		           
		          /* Date d=new Date();
		           Long time=d.getTime();
		           Timestamp ts=new Timestamp(time);
		            obj.orderedDate=orderTime;
		            /*Date d1=new Date();
		            Long time1=d1.getTime();
		            Timestamp ts1=new Timestamp(time1);*/
		           obj.orderedDate=orderTime;
		            obj.approxDeliveryTime =approxDeliveryTime; 
		           logger.debug("enter the totalamts");
		           obj.totalAmts=s.nextInt();
		           logger.debug("enter the afterdiscount");
		           obj.afterDiscount=s.nextInt();
		           ob.insertOrders(obj);
		           break;
		    case 2:
		    	   logger.debug("enter the orderid");
		    	   int orderId1=s.nextInt();
	               ob.calculateTotalAmts(orderId1);
	               break;
		    case 3:
		    	   logger.debug("enter the orderid");
		    	   int orderId2=s.nextInt();
		    	   ob.updateTotalAmts(orderId2);
		    	   break;
		    case 4:logger.debug("enter the orderid");
	    	       int orderId=s.nextInt();
	               ob.updateDeliveredDateAndStatus(orderId);
	               break;
		           default:logger.debug("Invalid choice");
		    	   break;
		   
		   /* case 5:logger.debug("enter the orderid");
		           int orderid=s.nextInt();
		           ob.updateDeliveredDate(orderid);*/
		
		}
	}

}