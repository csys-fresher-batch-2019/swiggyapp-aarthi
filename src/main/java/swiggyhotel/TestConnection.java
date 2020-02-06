package swiggyhotel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		int movieId=9;
		String movieName="aarthi";
   Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
   System.out.println(con);
   Statement stmt=con.createStatement();
 // String sql="insert into foodstuff_items(item_id,item_name,categories,price) values(17,'Mattan','NV',200)";
   //System.out.println(sql);
  // int rows=stmt.executeUpdate(sql);
  // System.out.print(rows);
  String sql1="insert into movies(movie_id,movie_name)values('"+movieId+"','"+movieName+"')";
   System.out.println(sql1);
    int row=stmt.executeUpdate(sql1);
   System.out.print(row);
   
  /* String sql2="select category from menus";
  // System.out.println(sql2);
   ResultSet ro=stmt.executeQuery(sql2);
   while(ro.next())
   {
	   String display=ro.getString("category");
	   System.out.println(display);
   }*/
   
   
   
   
   
   
   
	}

}
