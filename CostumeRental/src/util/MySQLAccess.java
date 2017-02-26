package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {

	private final static String DB_NAME = "costumerentaldb";
	private final static String USER = "root";
	private final static String PASSWORD = "root";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false",
					USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	// You need to close the resultSet
	public static void close(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {

		}
	}

}