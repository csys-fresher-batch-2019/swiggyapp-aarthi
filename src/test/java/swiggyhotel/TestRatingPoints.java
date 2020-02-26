package swiggyhotel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.RatingDAO;
import swiggyhotel.model.RatingDetails;
public class TestRatingPoints 
{
    public static final LoggerUtil logger=LoggerUtil.getInstance();
    public static void main(String[] args) throws Exception 
     {
		Scanner s=new Scanner(System.in);
		RatingDAO obj=DAOFactory.getRatingDAO();
		RatingDetails ob=new RatingDetails();
		logger.debug("1.InsertRatings\n2.FindAll\n3.GetRatings\n4.GetItemRatings\n");
		logger.debug("Enter the choice");
		int choice=s.nextInt();
		switch(choice)
		{
		    case 1:logger.debug("Enter the userId");
		           int userId=s.nextInt();
		           ob.setUserId(userId);
		           logger.debug("Enter the itemId");
		           int itemId=s.nextInt();
		           ob.setItemId(itemId);
		           logger.debug("Enter the ratingPoints(5-Excellent/4-Very Good/3-Good/2-Not Satisfy/1-poor)");
		           int ratingPoints=s.nextInt();
		           ob.setRatingPoints(ratingPoints);
		           obj.insertRatings(ob);
		           break;
	        case 2:List<RatingDetails> l=new ArrayList<RatingDetails>();
                   l=obj.findAll();
                   for (RatingDetails ratingDetails : l) 
                   {
		             logger.debug(ratingDetails);
	               }
                   break;
            case 3:logger.debug("Enter the itemname");
		           String itemName=s.next();
		           int rating=obj.getItemRatings(itemName);
		           logger.debug(rating);
		           break;
		    case 4:List<RatingDetails> list = new ArrayList<RatingDetails>();
			       logger.debug("Enter the itemname");
			       String itemName1=s.next();
	               list=obj.getRatings(itemName1);
	               for (RatingDetails ratingDetails : list)
	               {
	       		      logger.debug(ratingDetails);
	       	       }
	               break;
		   default:logger.debug("Invalid Choice");
                   break;		
	    }
	    s.close();
	}
}
