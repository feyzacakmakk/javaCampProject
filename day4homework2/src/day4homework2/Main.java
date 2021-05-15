package day4homework2;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager customerManager=new StarbucksCustomerManager(new MernisServiceAdapter());
		customerManager.Save(new Customer(1,"Feyza","Çakmak",12,"1111111111111"));
		
		BaseCustomerManager customerManager2=new NeroCustomerManager();
		customerManager2.Save(new Customer(1,"Feyza","Çakmak",12,"1111111111111"));
		
	}

}
