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
	
	//add new Mission into the table by requesting the new mission to add
	@PostMapping("/mission/add")
	public Mission addMission(@RequestBody Mission mission) throws SQLException, ClassNotFoundException{
		int result ; 
		Connection co = connection();
		

		String Query= "INSERT INTO Mission (`id`, `title`, `content`, `status`,`id_helper`,`id_asking`) VALUES"
				+ " ('"+mission.getId()+"', '"+mission.getTitle()+"', '"
					+mission.getContent()+"', '"+mission.getStatus()+"', '"+mission.getId_Asking()+"', '"+mission.getId_Asking()+"');" ;       
		try {
			Statement stm = co.createStatement() ;
			result = stm.executeUpdate(Query);
			
			if(result == 1) {

				System.out.println("Insert successful");
			
			}else {
				System.out.println("Error insert Mission ");
			}
		} catch (SQLException e) {
			System.out.println("Error insert Mission:   "+ e.getMessage());
		} 
		return mission ;	
	}
	
	//Return mission information by using Id
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
					int id_helper = result.getInt("id_helper");
					int id_asking = result.getInt("id_asking");
					mission = new Mission(id1,title,content,status,id_helper,id_asking) ;
				}
			} catch (SQLException e) {
				System.out.println("Error insert Mission:   "+ e.getMessage());
			} 
			return mission ; 
			
		}
		
		//Update Mission information by requesting the new mission information
		@PutMapping("/mission/update")
		public Mission updateMission(@RequestBody Mission mission) throws SQLException, ClassNotFoundException{
			int result ; 
			Connection co = connection();
			
			 String Query = "UPDATE Mission SET title = '" + mission.getTitle() + "', " +
	                 "content = '" + mission.getContent() + "', " +
	                 "status = " + mission.getStatus() + "id_helper = " + mission.getId_Helper() + "id_asking = " + mission.getId_Asking() + " WHERE id = " + mission.getId();
			try {
				Statement stm = co.createStatement() ;
				result = stm.executeUpdate(Query) ; 
				if(result ==1) {
					
					System.out.println("Update successful");
				
				}	
			} catch (SQLException e) {
				System.out.println("Error insert Mission:   "+ e.getMessage());
			} 
			return mission ;	
		}

		//Delete mission by using Id
		@DeleteMapping("/mission/delete/{id}")
		public String deleteMission(@PathVariable int id) throws SQLException, ClassNotFoundException{
			Connection co = connection();
			int result;
			
			String Query = "DELETE FROM Mission WHERE id = '" + id+"'";
			try {
				Statement stm = co.createStatement() ;
				result = stm.executeUpdate(Query) ; 
				if(result ==1) {
					return "delete Sucessful";
				}	
			} catch (SQLException e) {
				System.out.println("Error insert Mission:   "+ e.getMessage());
			} 
			return "Impossible to delete";
		}

}
