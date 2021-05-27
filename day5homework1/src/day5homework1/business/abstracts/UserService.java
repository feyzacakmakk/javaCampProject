package day5homework1.business.abstracts;

import day5homework1.core.concretes.GoogleAccountAdapter;
import day5homework1.entities.concretes.User;

public interface UserService {
	void addMail(User user);
	void addGoogle(GoogleAccountAdapter googleAccountAdapter);
	void delete(User user);
	

}
