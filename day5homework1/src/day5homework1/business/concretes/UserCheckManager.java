package day5homework1.business.concretes;

import day5homework1.business.abstracts.CheckService;
import day5homework1.entities.concretes.User;

public class UserCheckManager implements CheckService {

	boolean nameCheck(User user) {
		boolean ifISProper=false;
		int firstNameLength;
		int lastNameLength;
		firstNameLength=user.getFirstName().length();
		lastNameLength=user.getLastName().length();
		if (firstNameLength>=2 && lastNameLength>=2) {
			ifISProper=true;
		}
		return ifISProper;
		
	}
	
	boolean passwordCheck(User user) {
		boolean passwordCheck=false;
		int passwordLength;
		passwordLength=user.getPassword().length();
		if (passwordLength>=6) {
			passwordCheck=true;
		}
		return passwordCheck;
	}
}
