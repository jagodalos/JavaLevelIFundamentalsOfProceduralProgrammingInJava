package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Costume;
import model.Customer;
import model.Rent;
import util.CostumeRentalUtil;
import util.MySQLAccess;

public class RentDao {

	private final String DB_RENT_TABLE_NAME = "rent";
	private final String DB_COLUMN_DATE_TIME = "dateTime";
	private final String DB_COLUMN_CUSTOMER_ID = "customer_id";
	private final String DB_COLUMN_COSTUME_ID = "costume_id";

	private Connection connection;

	public RentDao() {
		connection = MySQLAccess.getConnection();
	}

	public List<Rent> getAllRentsByCustomer(int customerId) {
		List<Rent> rents = new ArrayList<Rent>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(
					"select rent.id, rent.dateTime, costume.id, costume.name, costume.price "
							+ "from rent " + "left join customer on rent.customer_id = customer.id "
							+ "left join costume on rent.costume_id = costume.id " + "where customer_id = "
							+ customerId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Rent rent = new Rent();
				Costume costume = new Costume();
				rent.setId(rs.getInt(1));
				rent.setDateTime(CostumeRentalUtil.getCurrentTimeStamp());
				costume.setId(rs.getInt(3));
				costume.setName(rs.getString(4));
				costume.setPrice(rs.getInt(5));
				rent.setCostume(costume);
				rents.add(rent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, rs, preparedStatement);
		}
		return rents;
	}

	public void rentCostume(int customerId, int costumeId) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("insert into " + DB_RENT_TABLE_NAME + "( " + DB_COLUMN_DATE_TIME + ", "
							+ DB_COLUMN_CUSTOMER_ID + ", " + DB_COLUMN_COSTUME_ID + " ) " + "values (?, ?, ?)");

			preparedStatement.setTimestamp(1, CostumeRentalUtil.getCurrentTimeStamp());
			preparedStatement.setInt(2, customerId);
			preparedStatement.setInt(3, costumeId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, null, preparedStatement);
		}
	}


	
}
