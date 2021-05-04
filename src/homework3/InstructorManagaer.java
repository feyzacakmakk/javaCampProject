package homework3;

public class InstructorManagaer extends UserManager{
    public void login(Instructor instructor) {
    	System.out.println(instructor.getFirstName()+" "+instructor.getLastName()+" isimli eðitmen giriþ yaptý.");
    	
	}
	
	
	public void giveHomework(Instructor instructor) {
		System.out.println("yeni ödev verildi.");
	}
	
	public void ShowInformation(Instructor instructor) {
		System.out.println("Adý: "+instructor.getFirstName());
		System.out.println("Soyadý: "+instructor.getLastName());
		System.out.println("Kullanýcý adý: "+instructor.getUserName());
		System.out.println("Id: "+instructor.getInstructorId());
		
	}

}
