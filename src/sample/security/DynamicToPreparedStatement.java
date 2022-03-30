package sample.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DynamicToPreparedStatement {
	
	public void originalSample(Connection connection, String departmentId) throws Exception {
        String query = "SELECT employee_id, first_name FROM employee WHERE department_id ='" + departmentId + "' ORDER BY last_name";
		Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()) {
        	String firstName = resultSet.getString(2);
        }

	}
	
	public void multipleMultipleSqlStatementsDeclaration() {
		String departmentId = "40";
		Connection connection = null;
		String query = "SELECT first_name FROM employee WHERE department_id ='" + departmentId + "' ";
		try {
			Statement statement = connection.createStatement(), statement2;
		    ResultSet resultSet = statement.executeQuery(query);
		    while(resultSet.next()) {
		    	String firstName = resultSet.getString(2);
		    }
		} catch (Exception e) {}
	}
	
	

	
	public void getResultSet() {
		String departmentId = "40";
		Connection connection = null;
		String query = "SELECT first_name FROM employee WHERE department_id ='" + departmentId + "'";
		try {
			Statement statement = connection.createStatement();
		    statement.execute(query);
		    ResultSet resultSet = statement.getResultSet();
		    while(resultSet.next()) {
		    	String firstName = resultSet.getString(1);
		    }
		} catch (Exception e) { }
	}
	
	public void multipleConcatenationStatements() {
		try {
			String departmentId = "40";
	        Connection connection = null;
	        String query = "SELECT employee_id, first_name FROM employee WHERE department_id ='";
	        query += departmentId;
	        query += "' ORDER BY last_name";
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);
	        while(resultSet.next()) {
	        	String firstName = resultSet.getString(2);
	        }
		} catch (Exception e) {
			
		}
	}
	
	public void multipleConcatenationStatements_expected() {
		try {
			String departmentId = "40";
	        Connection connection = null;
	        String query = "SELECT employee_id, first_name FROM employee WHERE department_id = ?";
	        query += " ORDER BY last_name";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        while(resultSet.next()) {
	        	String firstName = resultSet.getString(2);
	        }
		} catch (Exception e) {
			
		}
	}
	
	public void expectedSample() throws Exception {
		
		String departmentId = "40";
        Connection connection = null;
        String query = "SELECT employee_id, first_name FROM employee WHERE department_id = ? ORDER BY last_name";
        query += "";
        PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, departmentId);

	        ResultSet resultSet = statement.executeQuery();
	        while(resultSet.next()) {
	        	String firstName = resultSet.getString(2);
	        }
		} catch (Exception e) {
			return;
		}
	}
	
	public void multipleConcatenations() {
		String departmentId = "40";
		String id = "1";
		Connection connection = null;
		String query = "SELECT employee_id, first_name FROM employee WHERE department_id ='" + departmentId + "' AND employee_id = '" + id +  "' ORDER BY last_name";
		try {
			Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery(query);
		} catch (Exception e) { }
	
	}
}
	
