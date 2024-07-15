package in.lalit.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

	private JdbcUtil() {
		
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException, IOException {
		String dbLoc="/home/lalit/workspace-jee/JDBCMVC APP/src/main/java/in/lalit/properties/db.properties";
		FileInputStream fis = new FileInputStream(dbLoc);
		Properties properties = new Properties();
		properties.load(fis);
		String url= properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		Connection connection= DriverManager.getConnection(url,username, password);
		return connection;
	}
}
