package fr.insa.soa.Rest_TDProject;
import java.sql.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("user")
public class UserRessource {
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id")int id) throws SQLException, ClassNotFoundException {
		
		ResultSet result = null ; 
		Connection co = Sql_co.connection();
		User user = null;
	String Query= "SELECT * FROM User WHERE id=" + id; 
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
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User user) throws SQLException, ClassNotFoundException {
		
		int result ; 
		Connection co = Sql_co.connection();
		
		String Query= "INSERT INTO User (`id`, `username`, `password`, `type`) VALUES"
 				+ " ('"+user.getId()+"', '"+user.getUsername()+"', '"
					+user.getPassword()+"', '"+user.getType()+"');" ;   

		try {
			Statement stm = co.createStatement() ;
			
			result = stm.executeUpdate(Query);
			
			if(result == 1) {

				System.out.println("Insert successful");
			
			}else {
				System.out.println("Error insert User ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return user ;	
	}
}
