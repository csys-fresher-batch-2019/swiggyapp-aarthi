package swiggyhotel.Util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class ConnectionUtil {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "aarthi", "aarthi");
		System.out.println(con);
		return con;
	}

	public static Jdbi getjdbi() {
		Jdbi jdbi = null;
		try {
			Connection connection = getConnection();
			jdbi = Jdbi.create(connection);
			jdbi.installPlugin(new SqlObjectPlugin());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jdbi;

	}
}
