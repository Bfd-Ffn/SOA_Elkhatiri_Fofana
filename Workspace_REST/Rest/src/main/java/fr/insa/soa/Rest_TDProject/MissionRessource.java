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
					int id_helper = result.getInt("id_helper");
					int id_asking = result.getInt("id_asking");
					mission = new Mission(id1,title,content,status,id_helper,id_asking) ; 
				}
			} catch (SQLException e) {
				System.out.println("Error insert Mission:   "+ e.getMessage());
			} 
			return mission ; 
		}
	
		
		@Path("/add")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Mission addMission(Mission mission) throws SQLException, ClassNotFoundException {
			
			int result ; 
			Connection co = Sql_co.connection();
			
			String Query= "INSERT INTO Mission (`id`, `title`, `content`, `status`,`id_helper`,`id_asking`) VALUES"
					+ " ('"+mission.getId()+"', '"+mission.getTitle()+"', '"
						+mission.getContent()+"', '"+mission.getStatus()+"', '"+mission.getId_Helper()+"', '"+mission.getId_Asking()+"');" ;              
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
			return mission; 	
		}
		

}
