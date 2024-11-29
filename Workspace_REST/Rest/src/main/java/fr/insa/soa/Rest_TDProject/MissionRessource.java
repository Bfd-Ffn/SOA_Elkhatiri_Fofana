package fr.insa.soa.Rest_TDProject;
import java.sql.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("mission")
public class MissionRessource {

	
		@Path("/{id}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Mission getMission(@PathParam("id")int id) throws SQLException, ClassNotFoundException {
			
			ResultSet result = null ; 
			Connection co = Sql_co.connection();
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
	
		
		@Path("/add")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Mission addMission(Mission mission) throws SQLException, ClassNotFoundException {
			
			ResultSet result = null ; 
			Connection co = Sql_co.connection();
			
			
			String Query= "INSERT INTO Mission (`id`, `title`, `content`, `status`) VALUES ('"+mission.getId()+"', '"+mission.getTitle()+"', '"+mission.getContent()+"', '"+mission.getStatus()+"');" ; 
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
