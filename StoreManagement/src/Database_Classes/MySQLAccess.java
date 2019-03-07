package Database_Classes;

import java.sql.Connection;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySQLAccess {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;

	static {
		try {
			//FileInputStream fin = new FileInputStream("C:\\Users\\¾´\\git\\newspaperadmin\\NDS\\db.properties");
		/*	FileInputStream fin = new FileInputStream("E:\\NewsAgencyProject\\NewsAgency\\db.properties");
			
			Properties prop = new Properties();
			prop.load(fin);
		*/	driver= "com.mysql.cj.jdbc.Driver";
			url="jdbc:mysql://localhost:3306/assignment?useSSL=false";
					username="root";
					password="admin";

		/*	driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");*/
			Class.forName(driver);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * @Method: getConnection
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method: release
	 * @Description: release resources including Connection, Statement, ResultSet
	 *               objects
	 */
	public static void release(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}