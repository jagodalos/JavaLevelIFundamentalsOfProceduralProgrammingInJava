package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.LocalAttribute;

import javafx.util.converter.LocalDateStringConverter;
import model.Costume;
import model.Customer;
import model.Rent;
import util.MySQLAccess;

public class RentDao {

	private final String RENT_TABLE_NAME = "rent";
	private Connection connection;

	public RentDao() {
		connection = MySQLAccess.getConnection();
	}

//	public List<Rent> getAllRentsByCustomer(Customer customer) {
//		List<Rent> rents = new ArrayList<Rent>();
//		PreparedStatement preparedStatement = null;
//		ResultSet rs = null;
//		try {
//			preparedStatement = connection.prepareStatement("select  rent.id, rent.data, costume.id, costume.name, costume.price, co "
//					+ "from rent "
//					+ "left join customer on rent.customer_id = customer.id "
//					+ "left rentjoin costume on rent.costume_id = costume.id "
//					+ "where customer_id = ?"
//					);
//			preparedStatement.setInt(1, customer.getId());
//			rs = preparedStatement.executeQuery();
//			while (rs.next()) {
//				Rent rent = new Rent();
//				Costume costume = new Costume();
//				rent.setDate(LocalDate.now());
//				rent.setId(rs.getInt(1));
//				rent.setId(rs.);
//				
//				rent.setName(rs.getString());
//				rents.add(customer);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MySQLAccess.close(connection, rs, preparedStatement);
//		}
//
//		return customers;
//	}

	// public void addCustomer(Rent rent) {
	// PreparedStatement preparedStatement = null;
	// try {
	// preparedStatement = connection
	// .prepareStatement("insert into " + RENT_TABLE_NAME + "(name) values
	// (?)");
	//
	// preparedStatement.setString(1, rent.getName());
	// preparedStatement.executeUpdate();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// MySQLAccess.close(connection, null, preparedStatement);
	// }
	// }
	//
	// public List<Customer> getAllCustomers() {
	// List<Customer> customers = new ArrayList<Customer>();
	// PreparedStatement preparedStatement = null;
	// ResultSet rs = null;
	// try {
	// preparedStatement = connection.prepareStatement("select * from " +
	// COSTUMER_TABLE_NAME);
	// rs = preparedStatement.executeQuery();
	// while (rs.next()) {
	// Customer customer = new Customer();
	// customer.setName(rs.getString("name"));
	// customers.add(customer);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// MySQLAccess.close(connection, rs, preparedStatement);
	// }
	//
	// return customers;
	// }
	//
	// public Vector<String> getAllCustomersNames() {
	// Vector<String> customersNames = new Vector<String>();
	// PreparedStatement preparedStatement = null;
	// ResultSet rs = null;
	// try {
	// preparedStatement = connection.prepareStatement("select name from " +
	// COSTUMER_TABLE_NAME);
	// rs = preparedStatement.executeQuery();
	// while (rs.next()) {
	// customersNames.addElement(rs.getString("name"));
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// MySQLAccess.close(connection, rs, preparedStatement);
	// }
	//
	// return customersNames;
	// }
	//
	//
	// public Customer getCustomerById(int customerId) {
	// PreparedStatement preparedStatement = null;
	// ResultSet rs = null;
	// Customer customer = null;
	// try {
	// preparedStatement = connection.prepareStatement("select * from users
	// where uname=?");
	// preparedStatement.setInt(1, customerId);
	// rs = preparedStatement.executeQuery();
	//
	// if (rs.next()) {
	// customer = new Customer();
	// customer.setName(rs.getString("name"));
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// MySQLAccess.close(connection, rs, preparedStatement);
	// }
	//
	// return customer;
	// }

}
