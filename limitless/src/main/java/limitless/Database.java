package limitless;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private final static String url = "jdbc:mysql://localhost/limitless";
	private final static String user = "root";
	private final static String password = "aiwysiao";
	private final static String driver = "com.mysql.jdbc.Driver";

	private Connection con;

	public void connect() throws DatabaseException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DatabaseException("Driver not found.");
		}

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DatabaseException("Cannot connect.");
		}

	}

	public void disconnect() throws DatabaseException {
		try {
			con.close();
		} catch (SQLException e) {
			throw new DatabaseException("Unable to disconnect.");
		}
	}

}
