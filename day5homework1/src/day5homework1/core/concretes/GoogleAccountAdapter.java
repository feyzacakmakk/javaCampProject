package day5homework1.core.concretes;

import day5homework1.core.abtracts.GoogleAccountService;
import day5homework1.googleaccountsystem.GoogleAccountManager;

public class GoogleAccountAdapter implements GoogleAccountService{
	public void registerToSystem() {
		GoogleAccountManager gAccountManager=new GoogleAccountManager();
		gAccountManager.registerGoogleAccount();
	}

}
