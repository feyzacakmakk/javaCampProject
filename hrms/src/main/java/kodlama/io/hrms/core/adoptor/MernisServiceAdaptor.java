package kodlama.io.hrms.core.adoptor;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdaptor implements CheckMernisService{

	@Override
	public boolean checkIfRealTcNo(Candidate candidate) {
		/*KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

        boolean result=false;

        try {

            result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
                    candidate.getFirstName().toUpperCase(),
                    candidate.getLastName().toUpperCase(),
                    candidate.getBirthYear());

        } catch (Exception e) {

            System.out.println("böyle bir kişi yok");
        }

       return result; */
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
        boolean result=true;

	       try {
	           result= client.TCKimlikNoDogrula(
	                   Long.parseLong(candidate.getIdentityNumber()),
	                   candidate.getFirstName().toUpperCase(),
	                   candidate.getLastName().toUpperCase(),
	                   candidate.getBirthYear());
	           
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
		return result;
    }
	

}
