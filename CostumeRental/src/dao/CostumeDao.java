package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Costume;
import model.Customer;
import util.MySQLAccess;

public class CostumeDao {

	private final String COSTUME_TABLE_NAME = "costume";
	private Connection connection;

	public CostumeDao() {
		connection = MySQLAccess.getConnection();
	}

	public void addCostume(Costume costume) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into " + COSTUME_TABLE_NAME + "(name, price, available) values (?, ?, ?)");

			preparedStatement.setString(1, costume.getName());
			preparedStatement.setInt(2, costume.getPrice());
			preparedStatement.setString(3, costume.getAvailable());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, null, preparedStatement);
		}
	}
	
	public ResultSet getAllCostume() {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement("select * from " + COSTUME_TABLE_NAME);
			rs = preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			MySQLAccess.close(connection, null, preparedStatement);
		}
		return rs;
	}

}
