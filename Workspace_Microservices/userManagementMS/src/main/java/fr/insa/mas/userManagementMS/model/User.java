package fr.insa.mas.userManagementMS.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User")
public class User {
	
	private String Username ; 
	
	private String Password ; 
	
	private int Type ; 
	
	private int Id ;
	
	
	public User(int userid, String username2, String password2, int type2) {
		this.Id = userid;
		this.Password = password2;
		this.Type = type2;
		this.Username = username2;
	}
	
	public User(){
		
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		this.Type = type;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	

}
