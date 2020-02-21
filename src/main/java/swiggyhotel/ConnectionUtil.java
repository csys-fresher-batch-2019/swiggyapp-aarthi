package swiggyhotel;


import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionUtil {

	
	public static Connection getConnection() throws Exception   {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		   System.out.println(con);
		   return con;

	}

}
