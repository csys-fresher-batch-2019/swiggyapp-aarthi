package swiggyhotel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.UsersDAO;
import swiggyhotel.model.UserDetails;
public class TestUserDetails 
{
    public static final LoggerUtil logger=LoggerUtil.getInstance();
    public static void main(String[] args) throws Exception
      {
          UserDetails ob=new UserDetails();
          Scanner s=new Scanner(System.in);
          logger.debug("1.DisplayUserDetails\n2.InsertUserInfo\n3.Login\n4.GetNameAndtotalAmts\n5.GetUserId\n6.AdminLogin\n7.GetOrderId\n");
          logger.debug("Enter the choice");
          int choice=s.nextInt();
          UsersDAO obj=DAOFactory.getUsersDAO();
          switch(choice)
          {
              case 1:List<UserDetails> l1=new ArrayList<UserDetails>();
                     l1=obj.displayUserDetails();
                     for (UserDetails userDetails : l1)
                     {
		                logger.debug(userDetails);
			         }
                     break;
              case 2:logger.debug("Enter the username");
                     ob.setUserName(s.next());
                     logger.debug("Enter the phoneno");
                     ob.setPhoneNo(s.nextLong());
                     s.nextLine();
                     logger.debug("Enter the address");
                     ob.setAddress(s.nextLine());
                     logger.debug("Enter the city");
                     ob.setCity(s.next());
                     obj.insertUserInfo(ob);
                     break;
              case 3:logger.debug("Enter the username");
                     String userName=s.next();
                     logger.debug("Enter the phoneno");
                     Long phoneno=s.nextLong();
    	             String msg=obj.login(userName,phoneno);
                     logger.debug(msg);
                     break;
              case 4:logger.debug("Enter the orderId");
   	                 int orderId=s.nextInt();
                     HashMap<String,Integer> map = new HashMap<String, Integer>();
                     map=obj.getNameAndTotalAmts(orderId);
                     logger.debug(map);
                     break;
              case 5:logger.debug("Enter the username");
                     String userName1=s.next();
                     logger.debug("Enter the phoneno");
                     Long phoneno1=s.nextLong();
	                 int userId=obj.getUserId(userName1, phoneno1);
	                 logger.debug(userId);
	                 break;
              case 6:logger.debug("Enter the username");
                     String userName2=s.next();
                     logger.debug("Enter the password");
                     String passWord=s.next();
                     String message=obj.adminLogin(userName2,passWord);
                     logger.debug(message);
                     break;
	          case 7:int userId1=obj.getUserId("aaron",3214567890L);
		             int orderId1=obj.getOrderId(userId1);
	                 logger.debug(orderId1);
	                 break;
	         default:logger.debug("invalid choice");
                     break;
	      }
          s.close();
    }
}
    



