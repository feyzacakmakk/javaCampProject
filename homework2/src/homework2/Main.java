package homework2;

public class Main {

	public static void main(String[] args) {
		System.out.println("*KURSLAR*");
		Courses course1=new Courses("JAVA & REACT KAMPI","Engin DEMÝROÐ");
		System.out.println("kurs adý: "+course1.courseName);
		System.out.println("kurs eðitmeni: "+course1.teacher);
				
		Courses course2=new Courses("C# KAMPI","Engin DEMÝROÐ");
		System.out.println("kurs adý: "+course2.courseName);
		System.out.println("kurs eðitmeni: "+course2.teacher);
				
		Courses[] courses= {course1,course2};
		for (Courses coursess : courses) {
			System.out.println(coursess.courseName);
		}
			
		CourseManager course=new CourseManager();
		course.add(course1);
				
		System.out.println("*Sýk sorulan sorular*");
		Questions question1=new Questions(1, "kamp hangi günler olacak?","çarþamba ve cumartesi");
		Questions question2=new Questions(2, "kamp ne kadar sürecek?","2 ay");
		
		Questions[] questions= {question1,question2};
		for (Questions questions2 : questions) {
			System.out.println(questions2.number+": "+questions2.question);
			System.out.println(questions2.number+" sorunun cevabý: "+questions2.answer);
		}
		
		

	}

}
