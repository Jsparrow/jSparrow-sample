package sample.markers.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class UseParameterizedQuery {

	private Connection connection;

	void usingStatementExecute() throws SQLException {
		String departmentId = "40 OR '1'='1";
		String query = "SELECT first_name FROM employee WHERE department_id ='" + departmentId + "' ORDER BY last_name";
		Statement statement = connection.createStatement();
		statement.execute(query);
		ResultSet resultSet = statement.getResultSet();
	}
	
	void usingStatementExecuteQuery() throws Exception {
		String departmentId = "40 OR '1'='1";
		String query = "SELECT first_name FROM employee WHERE department_id ='" + departmentId + "' ORDER BY last_name";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
	}
	
	void multipleConcatenationLines() throws Exception {
		String departmentId = "40 OR '1'='1";
		int id = 10;
		String query = "SELECT first_name FROM employee WHERE";
		query += " id > '" + id + "'";
		query += " AND department_id ='" + departmentId + "'";
		query += " ORDER BY last_name";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
	}
}
