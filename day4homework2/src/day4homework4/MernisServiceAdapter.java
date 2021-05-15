package day4homework4;

import tr.gov.nvi.tckimlik.WS.KPSPublicLocator;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		 KPSPublicLocator client=new KPSPublicLocator();

	       try {
	           return client.TCKimlikNoDogrula(
	                   Long.parseLong(customer.getNationalityId()),
	                   customer.getFirstName().toUpperCase(),
	                   customer.getLastName().toUpperCase(),
	                   customer.getDateOfBirth());
	       }
	       catch (Exception e)
	       {
	           System.out.println("Error Message : "+e.getMessage());
	       

		return false;
	}

}
	
}
