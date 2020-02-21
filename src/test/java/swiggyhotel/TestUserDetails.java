package swiggyhotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.UsersDAO;
import swiggyhotel.model.UserDetails;

public class TestUserDetails {

	public static final LoggerUtil logger=LoggerUtil.getInstance();

     public static void main(String[] args) throws Exception {

    UserDetails ob=new UserDetails();
    Scanner s=new Scanner(System.in);
    logger.debug("1.displayUserDetails\n2.insertUserInfo\n3.login\n4.getNameAndtotalAmts\n5.getuserId\n6.adminlogin\n7.getorderid\n");
    logger.debug("enter the choice");
    int choice=s.nextInt();
    UsersDAO obj=DAOFactory.getUsersDAO();
    switch(choice)
     {
     case 1:  
     
     List<UserDetails> l1=new ArrayList<UserDetails>();
     l1=obj.displayUserDetails();
     for (UserDetails userDetails : l1) {
		logger.debug(userDetails.toString());
			}
     break;
     
     case 2:
    	 logger.debug("enter the username");
         ob.userName=s.next();
         logger.debug("enter the phoneno");
         ob.phoneNo=s.nextLong();
         s.nextLine();
         logger.debug("enter the address");
         ob.address=s.nextLine();
         logger.debug("enter the city");
         ob.city=s.next();
         obj.insertUserInfo(ob);
         break;
    	  
     /*case 3:
          List<String> l2=new ArrayList<String>();
          l2=obj.getNames(ob.city);
          for (String string : l2) {
    	 System.out.println(string);
		}
          break;*/
    case 3:System.out.println("enter the username");
           String userName=s.next();
           System.out.println("enter the phoneno");
           Long phoneno=s.nextLong();
    	   String msg=obj.login(userName,phoneno);
           System.out.println(msg);
           break;
     case 4:
    	   logger.debug("enter the orderId");
   	       int orderId=s.nextInt();
           HashMap<String,Integer> map = new HashMap<String, Integer>();
           map=obj.getNameAndtotalAmts(orderId);
           logger.debug(map);
           break;
     case 5:logger.debug("enter the username");
            String userName1=s.next();
            logger.debug("enter the phoneno");
            Long phoneno1=s.nextLong();
	        int userId=obj.getUserId(userName1, phoneno1);
	        logger.debug(userId);
	        break;
     case 6:logger.debug("enter the username");
            String userName2=s.next();
            logger.debug("enter the password");
            String passWord=s.next();
            String message=obj.adminLogin(userName2,passWord);
            logger.debug(message);
            break;
	        default:logger.debug("invalid choice");
            break;
	 case 7:int usersid=obj.getUserId("aaron",3214567890L);
		    int orderId1=obj.getOrderId(usersid);
	        logger.debug(orderId1);
	        break;
	}
     }
}
    

	/*private static void testInput() {
		Scanner s=new Scanner(System.in);
		int orderId=s.nextInt();
		}*/


