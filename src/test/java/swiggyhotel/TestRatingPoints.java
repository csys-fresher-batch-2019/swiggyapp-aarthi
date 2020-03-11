package swiggyhotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aarthi.swiggyhotel.exception.ValidatorException;
import com.aarthi.swiggyhotel.model.RatingPoint;
import com.aarthi.swiggyhotel.service.RatingPointService;
import com.aarthi.swiggyhotel.util.LoggerUtil;
import com.aarthi.swiggyhotel.validator.RatingPointDetailValidator;



public class TestRatingPoints {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		RatingPointDetailValidator rate = new RatingPointDetailValidator();
		RatingPointService service = new RatingPointService();
		RatingPoint ob = new RatingPoint();
		Scanner s = new Scanner(System.in);
		logger.debug("1.InsertRatings\n2.FindAll\n3.GetRatings\n4.GetItemRatings\n");
		logger.debug("Enter the choice");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			boolean userId = true;
			boolean itemId = true;
			boolean ratingPoint = true;
			logger.debug("Enter the userId");
			int userId1 = s.nextInt();
			ob.setUserId(userId1);
			try {
				userId = rate.checkUserId(userId1);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			logger.debug("Enter the itemId");
			int itemId1 = s.nextInt();
			ob.setItemId(itemId1);
			try {
				itemId = rate.checkItemId(itemId1);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			logger.debug("Enter the ratingPoints(5-Excellent/4-Very Good/3-Good/2-Not Satisfy/1-poor)");
			int ratingPoints = s.nextInt();
			ob.setRatingPoints(ratingPoints);
			try {
				ratingPoint = rate.checkRatingPoints(ratingPoints);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			if (userId == true || itemId == true || ratingPoint == true) {
				int value = service.insertRatings(ob);
				logger.debug(value);
			}
			break;
		case 2:
			List<RatingPoint> l = new ArrayList<RatingPoint>();
			l = service.findAll();
			for (RatingPoint ratingDetails : l) {
				logger.debug(ratingDetails);
			}
			break;
		case 3:
			logger.debug("Enter the itemname");
			String itemName = s.next();
			int rating = service.getItemRatings(itemName);
			logger.debug(rating);
			break;
		case 4:
			List<RatingPoint> list = new ArrayList<RatingPoint>();
			logger.debug("Enter the itemname");
			String itemName1 = s.next();
			list = service.getRatings(itemName1);
			for (RatingPoint ratingDetails : list) {
				logger.debug(ratingDetails);
			}
			break;
		default:
			logger.debug("Invalid Choice");
			break;
		}
		s.close();
	}
}
