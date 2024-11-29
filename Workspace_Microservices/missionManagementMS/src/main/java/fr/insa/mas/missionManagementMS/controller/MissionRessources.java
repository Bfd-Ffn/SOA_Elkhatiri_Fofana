package fr.insa.mas.missionManagementMS.controller;

import org.springframework.web.bind.annotation.*;


import java.sql.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

import fr.insa.mas.missionManagementMS.*;
import fr.insa.mas.missionManagementMS.model.Mission;


@RestController
public class MissionRessources {
	
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
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection( dbUri, dblogin, dbpwd);
		System.out.println ("connection successful");
		return conn;	
	}
	
	//Return user information by using Id
		@GetMapping(value="/mission/{id}")
		public Mission getMission(@PathVariable int id) throws SQLException, ClassNotFoundException {
			
			ResultSet result = null ; 
			Connection co = connection();
			Mission mission = null;
			
			String Query= "SELECT * FROM Mission WHERE id=" + id; 
			try {
				Statement stm = co.createStatement() ;
				result = stm.executeQuery(Query) ; 
				
				if(result.next()) {
					int id1 = result.getInt("id") ; 
					String title = result.getString("title") ; 
					String content = result.getString("content") ; 
					int status = result.getInt("status") ; 
					
					mission = new Mission(id1,title,content,status) ; 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return mission ; 
			
		}
		

}
