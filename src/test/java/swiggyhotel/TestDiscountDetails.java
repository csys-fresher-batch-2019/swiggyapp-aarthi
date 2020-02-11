package swiggyhotel;

import java.util.Scanner;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.DiscountDAO;
import swiggyhotel.model.DbException;

public class TestDiscountDetails {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		DiscountDAO ob= DAOFactory.getDiscountDAO();
		Scanner s=new Scanner(System.in);
		logger.debug("1.calculateDiscountAmt\n2.updateDiscountAmt");
		logger.debug("enter the choice");
		int choice=s.nextInt();
		switch(choice)
		{
		case 1:logger.debug("enter the orderid");
		       int orderId=s.nextInt();
		       int amt=ob.calculateDiscountAmt(orderId);
		       logger.debug(amt);
               break;
		case 2:logger.debug("enter the orderid");
		       int orderId1=s.nextInt();
               ob.updateDiscountAmt(orderId1);
               break;
               default:logger.debug("Invalid choice");
               break;
	}

}
}
