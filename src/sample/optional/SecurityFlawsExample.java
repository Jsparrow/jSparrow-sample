package sample.optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SecurityFlawsExample {
	
	public void dynamicQueryExample() throws Exception {
		Request req = new Request();
		String queryold = "SELECT user_id FROM user_data WHERE user_name = '" 
	              + req.getParameter("userID")
	              + "' and user_password = '" + req.getParameter("pwd") +"'";
		
		Connection connection = null;
		Statement statement = connection.createStatement();
		statement.execute(queryold);
		statement.executeQuery(queryold);
		statement.getResultSet();
		
		String query = "SELECT user_id FROM user_data WHERE user_name = ? and user_password = ?";
		String userName = req.getParameter("userID");
		String userPassword = req.getParameter("pwd");
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, userName);
		preparedStatement.setString(2, userPassword);
		preparedStatement.execute();
		
		
		
		
		

	}
	
	
	class Request {
		public String getParameter(String parameter) {
			return "";
		}
	}

}
