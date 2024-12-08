package fr.insa.soa.Rest_TDProject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.*;

public class Sql_co {
	
	public static Connection connection() throws SQLException, ClassNotFoundException  {

		Class.forName("com.mysql.jdbc.Driver");
	
		Connection conn = DriverManager.getConnection("jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_053", "projet_gei_053", "Aarei9hi");
	
		System.out.println ("connection successful");
	
		return conn;
		
		
	}
}
