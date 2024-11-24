package fr.insa.mas.userManagementMS.controller;

import org.springframework.web.bind.annotation.*;


import java.sql.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

import fr.insa.mas.userManagementMS.*;
import fr.insa.mas.userManagementMS.model.User;

@RestController
public class UserRessources {
	@Value("${server.port}")
	private String serverPort;
	
	@Value("${db.connection}")
	private String typeConnectionDB;
	
	@Value("${db.host}")
	private String dbHost;
	
	@Value("${db.port}")
	private String dbPort;
	
	@Value("${db.uri}")
	private String dbUri;
	
	@Value("${db.name}")
	private String dbname;
	
	@Value("${db.login}")
	private String dblogin;
	
	@Value("${db.pwd}")
	private String dbpwd;
	
	
	//Enable connection to database 
	public Connection connection() throws SQLException, ClassNotFoundException  {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection( dbUri, dblogin, dbpwd);
		System.out.println ("connection successful");
		return conn;	
	}
	

	//Return user information by using Id
	@GetMapping(value="/user/{id}")
	public User getUser(@PathVariable int id) throws SQLException, ClassNotFoundException {
		
		ResultSet result = null ; 
		Connection co = connection();
		User user = null;
		
		String Query= "SELECT * FROM User WHERE id= '" + id+"'"; 
		try {
			Statement stm = co.createStatement() ;
			result = stm.executeQuery(Query) ; 
			if(result.next()) {
				int Userid = result.getInt("id") ; 
				String username = result.getString("username") ; 
				String password = result.getString("password") ; 
				int type = result.getInt("type") ; 
				
				user = new User(Userid,username,password,type); 	
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return user ; 
		
	}
	
	//UPdate user information by requesting the user( is full info )
	@PutMapping("/user/update")
	public User updateUser(@RequestBody User user) throws SQLException, ClassNotFoundException{
		int result ; 
		Connection co = connection();
		
		 String Query = "UPDATE User SET username = '" + user.getUsername() + "', " +
                 "password = '" + user.getPassword() + "', " +
                 "type = " + user.getType() + " WHERE id = " + user.getId();
		try {
			Statement stm = co.createStatement() ;
			result = stm.executeUpdate(Query) ; 
			if(result ==1) {
				
				/*user.setUsername(result.getString("username") ); 
				user.setPassword( result.getString("password")); 
				user.setType(result.getInt("type")) ; */
				
			
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return user ;	
	}

	//Delete user by using Id
	@DeleteMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable int id) throws SQLException, ClassNotFoundException{
		int success=0;
		Connection co = connection();
		int result;
		
		String Query = "DELETE FROM User WHERE id = '" + id+"'";
		try {
			Statement stm = co.createStatement() ;
			result = stm.executeUpdate(Query) ; 
			if(result ==1) {
				
				/*user.setUsername(result.getString("username") ); 
				user.setPassword( result.getString("password")); 
				user.setType(result.getInt("type")) ; */
				return "delete Sucessful";
			
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return "Impossible to delete";
	}

}



