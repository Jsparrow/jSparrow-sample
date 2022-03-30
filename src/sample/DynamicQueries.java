package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicQueries {
	
	Logger logger = LoggerFactory.getLogger(DynamicQueries.class);
	
    private static final String USERNAME = "hr";
    private static final String PASSWORD = "hr";
    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@//localhost:1521/orcl";
    
    private void tryCatchForSqlExceptions(int departmentId, String lastName) {

        Connection connection;
		try {
			connection = getOracleConnection(CONNECTION_STRING, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
        logger.debug("Connection {}", connection);
        String query = "SELECT employee_id, first_name,last_name, hire_date, salary FROM employee WHERE department_id ='" + departmentId + " ORDER BY last_name";
        query += "";
        logger.debug("Query: '{}'", query);
        Statement statement;
		try {
			statement = connection.createStatement();
			logger.debug("Statement {}", statement);

	        ResultSet resultSet = statement.executeQuery(query);
	        while(resultSet.next()) {
	        	String firstName = resultSet.getString(2);
	        	logger.debug("First name: {}", firstName);
	        }
		} catch (SQLException e) {
			return;
		}
    }

    private void statementGetResultSet(String firstName, String lastName) throws Exception {

        Connection connection = getOracleConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        String query = "SELECT * FROM employee WHERE first_name ='" + firstName + "' AND last_name='" + lastName + "' ";
        Statement statement = connection.createStatement();
        statement.execute(query);
        ResultSet resultSet = statement.getResultSet();
    }
    
    private void statementExecuteQuery(String firstName, String lastName) throws Exception {

        Connection connection = getOracleConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        String query = "SELECT * FROM employee WHERE first_name ='" + firstName + "' AND last_name='" + lastName + "' ";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
    }
    
    private void statementsInBetween(int departmentId, String lastName) throws Exception {

        Connection connection = getOracleConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        logger.debug("Connection {}", connection);
        String query = "SELECT employee_id, first_name,last_name, hire_date, salary FROM employee WHERE department_id ='" + departmentId + "'";
        query += " ORDER BY last_name";
        logger.debug("Query: '{}'", query);
        Statement statement = connection.createStatement();
        logger.debug("Statement {}", statement);
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()) {
        	String firstName = resultSet.getString(2);
        	logger.debug("First name: {}", firstName);
        }
    }
    
    

    
    public static Connection getOracleConnection(String connectString, String username, String password) throws Exception {
        String driver = "oracle.jdbc.OracleDriver";
        Class.forName(driver); // load Oracle driver
        return DriverManager.getConnection(connectString, username, password);
    }
    
    private void playingWithBlocks(String firstName, String lastName) throws Exception {

        Connection connection = getOracleConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        String query = "SELECT * FROM employee WHERE first_name ='" + firstName + "' AND last_name='" + lastName + "' ";
        Statement statement = connection.createStatement();
        statement.execute(query);
    }
    
    public void originalSample3(Connection connection, String departmentId, int id) throws Exception {
        String query = "SELECT first_name FROM employee WHERE";
        query += " id > '" + id + "'";
        query += " AND department_id ='" + departmentId + "'";
        query += " ORDER BY last_name";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
    }
    
    public void originalSample4(Connection connection, String departmentId, int id) throws Exception {

        String query = "SELECT " + " employee_id, first_name FROM employee WHERE department_id ='" + departmentId + "'"
        		+ " OR department_id = ?" + "" +
        		" ORDER BY last_name";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
    }
    
	public void sampleMethod(Connection connection, String departmentId1, String departmentId2) throws Exception {
	    String query = "" + 
	            "SELECT" +
	            "   employee_id" +
	            "   , first_name" +
	            "   FROM" +
	            "       employee" +
	            "   WHERE" + 
	            "       department_id =" + "'" + departmentId1 + "'" + 
	            "   OR" +
	            "       department_id =" + "'" + departmentId2 + "'" + 
	            "   ORDER BY last_name";
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery(query);
	}
    


}
