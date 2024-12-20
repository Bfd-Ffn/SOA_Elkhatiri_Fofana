package fr.insa.soap;
import java.net.MalformedURLException ;
import javax.xml.ws.Endpoint;



public class UserServicesApplication {
	
	public static String host ="localhost";
	public static short port = 8089;
	public void demarrerService()
	{
		String url = "http://"+host+":"+port+"/";
		Endpoint.publish(url, new UserServices());
		
	}
	public static void main(String [] args) throws MalformedURLException{
		new UserServicesApplication().demarrerService();
		System.out.println("Le service a demarré");
	}
	
}
