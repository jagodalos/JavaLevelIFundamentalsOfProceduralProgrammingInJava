package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Costume;
import util.MySQLAccess;

public class CostumeDao {

	private final String DB_COSTUME_TABLE_NAME = "costume";
	private final String DB_COLUMN_ID = "id";
	private final String DB_COLUMN_NAME = "name";
	private final String DB_COLUMN_PRICE = "price";
	private final String DB_COLUMN_AVAILABLE = "available";

	private Connection connection;


	public CostumeDao() {
		connection = MySQLAccess.getConnection();
	}

	public void addCostume(Costume costume) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("insert into " + DB_COSTUME_TABLE_NAME + "( " + DB_COLUMN_NAME + ", "
							+ DB_COLUMN_PRICE + ", " + DB_COLUMN_AVAILABLE + " ) " + "values (?, ?, ?)");

			preparedStatement.setString(1, costume.getName());
			preparedStatement.setBigDecimal(2, costume.getPrice());
			preparedStatement.setBoolean(3, costume.isAvailable());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, null, preparedStatement);
		}
	}

	public void updateCostume(Costume costume) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("update " + DB_COSTUME_TABLE_NAME + " set " + DB_COLUMN_NAME + "=?, "
							+ DB_COLUMN_PRICE + "=?, " + DB_COLUMN_AVAILABLE + "=? where " + DB_COLUMN_ID + "=?");

			preparedStatement.setString(1, costume.getName());
			preparedStatement.setBigDecimal(2, costume.getPrice());
			preparedStatement.setBoolean(3, costume.isAvailable());
			preparedStatement.setInt(4, costume.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, null, preparedStatement);
		}

	}
	
	public List<Costume> getAllAvaiableCostume() {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Costume> costumes = new ArrayList<Costume>();
		try {
			preparedStatement = connection.prepareStatement(
					"select * from " + DB_COSTUME_TABLE_NAME + " where " + DB_COLUMN_AVAILABLE + " = 1");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Costume costume = new Costume();
				costume.setId(rs.getInt(DB_COLUMN_ID));
				costume.setName(rs.getString(DB_COLUMN_NAME));
				costume.setPrice(rs.getBigDecimal(DB_COLUMN_PRICE));
				costume.setAvailable(rs.getBoolean(DB_COLUMN_AVAILABLE));
				costumes.add(costume);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, null, preparedStatement);
		}
		return costumes;
	}
	
	public void setCostumeAvailable(int costumeId, boolean isCostumeAvailable) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("update " + DB_COSTUME_TABLE_NAME + " set " + DB_COLUMN_AVAILABLE + "=? where " + DB_COLUMN_ID + "=?");

			preparedStatement.setBoolean(1, isCostumeAvailable);
			preparedStatement.setInt(2, costumeId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, null, preparedStatement);
		}

	}
	

}
