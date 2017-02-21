package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Costume;
import model.Customer;
import util.MySQLAccess;

public class CostumeDao {

	private final String DB_COSTUME_TABLE_NAME = "costume";
	private final String DB_ID = "id";
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
			preparedStatement.setInt(2, costume.getPrice());
			preparedStatement.setBoolean(3, costume.isAvailable());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, null, preparedStatement);
		}
	}

//	public DefaultTableModel getAllCostume() {
//		PreparedStatement preparedStatement = null;
//		ResultSet rs = null;
//		DefaultTableModel model = new DefaultTableModel(tableCostumeColumnNames, 0);
//		try {
//			preparedStatement = connection.prepareStatement(
//					"select " + DB_COLUMN_NAME + ", " + DB_COLUMN_PRICE + " from " + DB_COSTUME_TABLE_NAME);
//			rs = preparedStatement.executeQuery();
//			while (rs.next()) {
//				model.addRow(new Object[] { rs.getString(DB_COLUMN_NAME), rs.getInt(DB_COLUMN_PRICE) });
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MySQLAccess.close(connection, null, preparedStatement);
//		}
//		return model;
//	}

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
				costume.setId(rs.getInt(DB_ID));
				costume.setName(rs.getString(DB_COLUMN_NAME));
				costume.setPrice(rs.getInt(DB_COLUMN_PRICE));
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

}
