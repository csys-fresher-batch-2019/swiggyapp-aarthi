package swiggyhotel;


import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionUtil {

	//public static void main(String[] args) throws Exception {
		
	//	int movieId=7;
	//	String movieName="darbar";
	public static Connection getConnection() throws Exception   {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		   System.out.println(con);
		 /* Statement stmt=con.createStatement();
		   String sql1="delete from movies where movie_name='"+movieName+"'";
		   System.out.println(sql1);
		    int row=stmt.executeUpdate(sql1);
		   System.out.print(row);*/
		  /* String sql1="insert into movies(movie_id,movie_name)values('"+movieId+"','"+movieName+"')";
		   System.out.println(sql1);
		    int row=stmt.executeUpdate(sql1);
		   System.out.print(row);*/
		return con;

	}

}
