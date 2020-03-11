package swiggyhotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import swiggyhotel.Exception.ValidatorException;
import swiggyhotel.logger.LoggerUtil;
import swiggyhotel.model.UserDetails;
import swiggyhotel.service.LoginFormValidationService;
import swiggyhotel.service.RegisterFormValidationService;
import swiggyhotel.service.UserDetailsService;

public class TestUserDetails {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		UserDetails ob = new UserDetails();
		UserDetailsService service = new UserDetailsService();

		RegisterFormValidationService register = new RegisterFormValidationService();
		LoginFormValidationService login = new LoginFormValidationService();

		Scanner s = new Scanner(System.in);
		logger.debug(
				"1.FindAll\n2.InsertUserInfo\n3.Login\n4.GetNameAndtotalAmts\n5.GetUserId\n6.AdminLogin\n7.GetOrderId\n8.ValidNumber\n");
		logger.debug("Enter the choice");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			List<UserDetails> l1 = new ArrayList<UserDetails>();
			l1 = service.displayUserDetails();
			for (UserDetails userDetails : l1) {
				logger.debug(userDetails);
			}
			break;
		case 2:
			boolean name = true;
			boolean phoneNo = true;
			logger.debug("Enter the username(Lower Case Alphabets Only)");
			String name1 = s.next();
			ob.setUserName(name1);
			try {
				name = register.checkName(name1);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			logger.debug("Enter the phoneno(10-digit)");
			Long phoneNo1 = s.nextLong();
			ob.setPhoneNo(phoneNo1);
			try {
				phoneNo = register.checkPhoneNo(phoneNo1);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			s.nextLine();
			logger.debug("Enter the address");
			ob.setAddress(s.nextLine());
			logger.debug("Enter the city");
			ob.setCity(s.next());
			if (name == true && phoneNo == true) {
				int value = service.insertUserInfo(ob);
				logger.debug(value);
			}
			break;
		case 3:
			boolean userName1 = true;
			boolean phoneNo2 = true;
			logger.debug("Enter the username(Lower case Alphabets Only)");
			String userName = s.next();
			try {
				userName1 = login.checkName(userName);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			logger.debug("Enter the phoneno");
			Long phoneno = s.nextLong();
			try {
				phoneNo2 = login.checkPhoneNo(phoneno);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			if(userName1==true&&phoneNo2==true) {
			String value1 = service.login(userName, phoneno);
			logger.debug(value1);
			}
			break;
		case 4:
			logger.debug("Enter the orderId");
			int orderId = s.nextInt();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map = service.getNameAndTotalAmts(orderId);
			logger.debug(map);
			break;
		case 5:
			logger.debug("Enter the username(Lower Case Alphabets Only)");
			String userName2 = s.next();
			logger.debug("Enter the phoneno");
			Long phoneno1 = s.nextLong();
			int userId = service.getUserId(userName2, phoneno1);
			logger.debug(userId);
			break;
		case 6:
			boolean username = true;
			boolean password = true;
			logger.debug("Enter the username(Lower Case Alphabets Only)");
			String userName3 = s.next();
			try {
				username = register.checkUserName(userName3);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			logger.debug("Enter the password");
			String passWord = s.next();
			try {
				password = register.checkPassWord(passWord);
			} catch (ValidatorException e) {
				logger.error(e.getMessage());
			}
			if (username == true && password == true) {
				String message = service.adminLogin(userName3, passWord);
				logger.debug(message);
			}
			break;
		case 7:
			int userId1 = service.getUserId("Aarthi", 9234567890L);
			int orderId1 = service.getOrderId(userId1);
			logger.debug(orderId1);
			break;
		case 8:
			int number = service.validNumber(9234567890L);
			logger.debug(number);
			break;
		default:
			logger.debug("invalid choice");
			break;
		}
		s.close();
	}
}
