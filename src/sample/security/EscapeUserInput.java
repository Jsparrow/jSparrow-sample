package sample.security;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.OracleCodec;
import org.owasp.esapi.codecs.Codec;

public class EscapeUserInput {
	
	private void escapeUserInputSample(Connection connection, String input, HttpServletRequest servletRequest) throws SQLException {
		
		Codec<Character> oracleCodec = new OracleCodec();
		String query = "SELECT first_name FROM employee WHERE department_id ='" + ESAPI.encoder().encodeForSQL(oracleCodec, servletRequest.getParameter("departmentId")) + "' ORDER BY last_name";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
	}

}
