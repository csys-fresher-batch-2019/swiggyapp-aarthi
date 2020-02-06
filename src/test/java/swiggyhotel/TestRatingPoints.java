package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.RatingDAO;
import swiggyhotel.model.RatingDetails;

public class TestRatingPoints {

	public static final LoggerUtil logger=LoggerUtil.getInstance();
	
	public static void main(String[] args) throws Exception {
		Scanner s=new Scanner(System.in);
		RatingDAO obj=DAOFactory.getRatingDAO();
		RatingDetails ob=new RatingDetails();
		logger.debug("1.insertRatings\n2.findAll\n3.getRatings\n");
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
		  logger.debug(ratingDetails.toString());
	      }
          break;
          
		  case 3:logger.debug("enter the itemname");
		         String itemname=s.next();
		         obj.getRatings(itemname);
		         break;
		  default:logger.debug("Invalid choice");
                break;		
	   }

}
}
