package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.RatingDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.RatingDetails;

public class TestRatingPoints {

	public static final LoggerUtil logger=LoggerUtil.getInstance();
	
	public static void main(String[] args) throws Exception {
		Scanner s=new Scanner(System.in);
		RatingDAO obj=DAOFactory.getRatingDAO();
		RatingDetails ob=new RatingDetails();
		logger.debug("1.insertRatings\n2.findAll\n3.getRatings\n4.getItemRatings\n");
		logger.debug("enter the choice");
		int choice=s.nextInt();
		switch(choice)
		{
		case 1:
		
	    logger.debug("enter the userId");
		int userId=s.nextInt();
		ob.setUserId(userId);
		logger.debug("enter the itemId");
		int itemId=s.nextInt();
		ob.setItemId(itemId);
		logger.debug("enter the ratingPoints(5-Excellent/4-Very Good/3-Good/2-Not satisfy/1-poor)");
		int ratingPoints=s.nextInt();
		ob.setRatingPoints(ratingPoints);
		obj.insertRatings(ob);
		break;
		
		case 2:
	      List<RatingDetails> l=new ArrayList<RatingDetails>();
          l=obj.findAll();
          for (RatingDetails ratingDetails : l) {
		  logger.debug(ratingDetails);
	      }
          break;
          
		  case 3:logger.debug("enter the itemname");
		         String itemname=s.next();
		         int rating=obj.getItemRatings(itemname);
		         break;
		  case 4:List<RatingDetails> list = new ArrayList<RatingDetails>();
			     logger.debug("enter the itemname");
			     String itemname1=s.next();
	             list=obj.getRatings(itemname1);
	             for (RatingDetails ratingDetails : list) {
	       		  logger.debug(ratingDetails);
	       	      }
	             break;
		  default:logger.debug("Invalid choice");
                break;		
	   }

}
}
