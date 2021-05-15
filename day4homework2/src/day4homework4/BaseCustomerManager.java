package day4homework4;

public abstract class BaseCustomerManager implements CustomerService{

	@Override
	public void Save(Customer customer) {
		System.out.println("saved to db: "+customer.getFirstName());
		
	}

}
