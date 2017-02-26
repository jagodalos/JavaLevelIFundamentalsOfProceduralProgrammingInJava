package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import util.MySQLAccess;

public class CustomerDao {

	private final String COSTUMER_TABLE_NAME = "customer";
	private final String DB_COLUMN_ID = "id";
	private final String DB_COLUMN_NAME = "name";
	private Connection connection;

	public CustomerDao() {
		connection = MySQLAccess.getConnection();
	}

	public void addCustomer(Customer customer) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("insert into " + COSTUMER_TABLE_NAME + "("+ DB_COLUMN_NAME + ") values (?)");
			preparedStatement.setString(1, customer.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, null, preparedStatement);
		}
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement("select * from " + COSTUMER_TABLE_NAME);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt(DB_COLUMN_ID));
				customer.setName(rs.getString(DB_COLUMN_NAME));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, rs, preparedStatement);
		}

		return customers;
	}		

}
