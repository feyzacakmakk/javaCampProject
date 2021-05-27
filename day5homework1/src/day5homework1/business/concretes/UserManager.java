package day5homework1.business.concretes;

import day5homework1.business.abstracts.UserService;
import day5homework1.core.concretes.GoogleAccountAdapter;
import day5homework1.entities.concretes.User;

public class UserManager implements UserService{

	private UserCheckManager userCheckManager;
	private MailCheckManager mailCheckManager;
	private MailVerificationManager mailVerificationManager;
	
	public UserManager(UserCheckManager userCheckManager, MailCheckManager mailCheckManager, MailVerificationManager mailVerificationManager) {
		this.userCheckManager=userCheckManager;
		this.mailCheckManager=mailCheckManager;
		this.mailVerificationManager=mailVerificationManager;
	}
	
	
	@Override
	public void addMail(User user) {
		if (userCheckManager.nameCheck(user) && userCheckManager.passwordCheck(user) && mailCheckManager.isEmailValid(user.getMail())) 
		{
			System.out.println("Doðrulama e-postasý gönderildi.");
			mailVerificationManager.ifIsVerificationLinkClicked();
			System.out.println("Kullanýcý eklendi.");
			
		}
		else {
			System.out.println("kullanýcý bilgileri yanlýþ.");
			return;
		}
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addGoogle(GoogleAccountAdapter googleAccountAdapter) {
		googleAccountAdapter.registerToSystem();
	}

}
