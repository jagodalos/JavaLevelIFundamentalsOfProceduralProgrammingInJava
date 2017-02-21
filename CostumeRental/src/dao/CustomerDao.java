package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.Customer;
import util.MySQLAccess;

public class CustomerDao {

	private final String COSTUMER_TABLE_NAME = "customer";
	private final String DB_ID = "id";
	private final String DB_COLUMN_NAME = "name";
	private Connection connection;

	public CustomerDao() {
		connection = MySQLAccess.getConnection();
	}

	public void addCustomer(Customer customer) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("insert into " + COSTUMER_TABLE_NAME + "(name) values (?)");

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
				customer.setId(rs.getInt(DB_ID));
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

	public Customer getCustomerById(int customerId) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Customer customer = null;
		try {
			preparedStatement = connection.prepareStatement("select * from users where uname=?");
			preparedStatement.setInt(1, customerId);
			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				customer = new Customer();
				customer.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, rs, preparedStatement);
		}

		return customer;
	}

}
