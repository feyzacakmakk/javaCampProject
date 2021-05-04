package homework3;

public class StudentManager extends UserManager{
	public void login(Student student) {
		System.out.println(student.getFirstName()+" "+student.getLastName()+" isimli öðrenci giriþ yaptý.");
	}
	
	
	public void doHomework(Student student) {
		System.out.println("ödev yapýldý.");
	}
	
	
	public void ShowInformation(Student student) {
		System.out.println("Adý: "+student.getFirstName());
		System.out.println("Soyadý: "+student.getLastName());
		System.out.println("Kullanýcý adý: "+student.getUserName());
		System.out.println("Okul ismi: "+student.getSchoolName());
		
	}
	
	
	
	

}
