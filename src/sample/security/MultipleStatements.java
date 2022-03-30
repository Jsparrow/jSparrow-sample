package sample.security;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MultipleStatements {
	
	public void multipleStatements(Connection connection) throws Exception {
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
