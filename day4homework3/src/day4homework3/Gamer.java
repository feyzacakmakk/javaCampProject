package day4homework3;

public class Gamer implements Entity{
	private String Tcno;
	private String firstName;
	private String lastName;
	private int yearOfBirth;
	
	public Gamer() {}

	public Gamer(String TcNo, String firstName, String lastName, int yearOfBirth, int id) {
		this.Tcno = TcNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
	}
	
	public Gamer(String firstName) {
		this.firstName=firstName;
	}

	public String getTcno() {
		return Tcno;
	}

	public void setTcno(String tcno) {
		Tcno = tcno;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
}
