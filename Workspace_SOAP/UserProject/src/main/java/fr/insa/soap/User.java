package fr.insa.soap;

import javax.jws.WebService;

@WebService(serviceName="user")

public class User {
	
	public String Username;
	public String Password;
	
	public int type;
	
	public int id;

	public User(String username, String password, int type, int id) {
		this.Username = username;
		this.Password = password;
		this.type = type;
		this.id = id;
	}
	
	

}
