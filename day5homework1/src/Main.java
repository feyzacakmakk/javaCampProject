
import day5homework1.business.abstracts.UserService;
import day5homework1.business.concretes.MailCheckManager;
import day5homework1.business.concretes.MailVerificationManager;
import day5homework1.business.concretes.UserCheckManager;
import day5homework1.business.concretes.UserLoginManager;
import day5homework1.business.concretes.UserManager;
import day5homework1.core.concretes.GoogleAccountAdapter;
import day5homework1.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user=new User("feyza", "çakmak","feyza@gmail.com", "1234567");
		UserService userManager=new UserManager(new UserCheckManager(), new MailCheckManager(), new MailVerificationManager());
		userManager.addMail(user);
		GoogleAccountAdapter googleAccountAdapter=new GoogleAccountAdapter();
		userManager.addGoogle(googleAccountAdapter);
		
		UserLoginManager userLoginManager=new UserLoginManager();
		userLoginManager.login(user);
		

	}

}
