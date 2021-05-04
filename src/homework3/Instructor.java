package homework3;

public class Instructor extends User{
	private int instructorId;

	public Instructor(String firstName, String lastName, String userName, int instructorId) {
		super(firstName, lastName, userName);
		this.instructorId = instructorId;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	
	

}
