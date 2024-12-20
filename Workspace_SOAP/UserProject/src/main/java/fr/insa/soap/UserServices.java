package fr.insa.soap;
import java.util.ArrayList;
import java.util.List;

import javax.jws.*;


@WebService(serviceName="UserServices")
public class UserServices {
	public List<User> BDD =new ArrayList<User>();

	
	@WebMethod(operationName="createUser")
	public User createUserlocally(@WebParam(name="Username") String username,
			@WebParam(name="Password") String password,
			@WebParam(name="Type") int type,
			@WebParam(name="ID") int id) {
		User user =new User(username,password,type,id);
		BDD.add(user);
		System.out.println("User crée est ajouté localement");
		
		//Affiche la liste de tout nos user present actuellement dans notre list 
		for(int i =0;i<BDD.size();i++) {
			System.out.println(BDD.get(i).Username+"\n");
		}
		
		return user;
		
	}

	
}
