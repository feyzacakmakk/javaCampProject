package homework3;

public class UserManager {
	public void login(User user) {
		System.out.println(user.getFirstName()+" giriþ yaptý.");
	}
	
	public void loginMultiple(User[] users) {
		for (User user : users) {
			login(user);
		}
		
	}
	
	public void ShowInformation(User user) {
		System.out.println("Adý: "+user.getFirstName());
		System.out.println("Soyadý: "+user.getLastName());
		System.out.println("Kullanýcý adý: "+user.getUserName());
		
	}
	
	public void ShowInfo(User[] users) {
		for (User user : users) {
			ShowInformation(user);
		}
	}
	

}
