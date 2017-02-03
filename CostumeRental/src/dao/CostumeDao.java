package dao;

import com.mysql.jdbc.PreparedStatement;

public class CostumeDao {
	
	private final String COSTUME = "costume";

	public void add(String name, int price, String avilability) throws Exception {
		PreparedStatement preparedStatement = null;
		try {

			
			// PreparedStatements can use variables and are more efficient
			preparedStatement = (PreparedStatement) MySQLAccess.getConnection()
					.prepareStatement("insert into  " + MySQLAccess.getDbName() + "." + COSTUME + " values (default, ?, ?, ?)");
			// "myuser, webpage, datum, summary, COMMENTS from
			// feedback.comments");
			// Parameters start with 1
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, Integer.toString(price));
			preparedStatement.setString(3, avilability);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			MySQLAccess.close(MySQLAccess.getConnection(), null, preparedStatement);
		}
		
	}


	
	
}
