package fr.insa.soa.Rest_TDProject;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.*;

public class ClientRest {
	public static void main(String [] args) {
		Client client = ClientBuilder.newClient(); 
		Response response= client.target("http://localhost:8080/RestProject/webapi/myresource").request().get() ; 
		System.out.println(response.readEntity(String.class)) ; 
		
	}
}
