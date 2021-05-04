package homework3;

public class Student extends User{
	private String schoolName;

	public Student(String firstName, String lastName, String userName, String schoolName) {
		super(firstName, lastName, userName);
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	
	

}
