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
	private final String DB_ID = "id";
	private final String DB_DATA = "DATA";
	
	private Connection connection;

	public RentDao() {
		connection = MySQLAccess.getConnection();
	}

	public List<Rent> getAllRentsByCustomer(Customer customer) {
		List<Rent> rents = new ArrayList<Rent>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement("select rent.id, rent.data, costume.id, costume.name, costume.price, costume.available "
					+ "from rent "
					+ "left join customer on rent.customer_id = customer.id "
					+ "left join costume on rent.costume_id = costume.id "
					+ "where customer_id = " + customer.getId()
					);
			System.out.println(preparedStatement);

			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Rent rent = new Rent();
				Costume costume = new Costume();
				rent.setId(rs.getInt(1));
				rent.setDate(LocalDate.now());
				costume.setId(rs.getInt(3));
				costume.setName(rs.getString(4));
				costume.setPrice(rs.getInt(5));
//				costume.setAvailable(rs.getBoolean(6));
				rent.setCostume(costume);
				rents.add(rent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, rs, preparedStatement);
		}
		System.out.println(rents.size());
		return rents;
	}

}
