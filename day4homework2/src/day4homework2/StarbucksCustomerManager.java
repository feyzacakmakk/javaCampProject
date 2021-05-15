package day4homework2;

public class StarbucksCustomerManager extends BaseCustomerManager implements CustomerCheckService{

	CustomerCheckService customerCheckService;
	
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		this.customerCheckService=customerCheckService;
	}
		
	
	@Override
	public void Save(Customer customer) {
		
		if(customerCheckService.CheckIfRealPerson(customer))
		{
			super.Save(customer);
		}
		else {
			System.out.println("geçerli biri deðil.");
		}
		
		
	}


	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	



}
