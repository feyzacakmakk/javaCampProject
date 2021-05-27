package day5homework1.business.concretes;

import day5homework1.business.abstracts.UserLoginSystem;
import day5homework1.entities.concretes.User;


public class UserLoginManager implements UserLoginSystem{

	private String mail="feyza@gmail.com";
	private String password="1234567";
	
	@Override
	public void login(User user) {
		if (user.getMail()==mail && user.getPassword()==password) {
			System.out.println("baþarýlý bir þekilde giriþ yapýldý.");
		}
		else {
			System.out.println("Girilen bilgiler hatalýdýr.");
		}
		
	}
	

}
