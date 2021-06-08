package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.business.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.validation.VerificationService;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;



@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private VerificationService verificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,VerificationService verificationService) {
		super();
		this.employerDao=employerDao;
		this.verificationService=verificationService;
	}
	

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "iş verenler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		Result result=BusinessRules.run(nullControl(employer), webAddressDomainControl(employer.getWebAddress(), employer.getEmail()),
				existEmail(employer.getEmail()), isRealPhoneNumber(employer.getPhoneNumber()));
		
		if (result.isSuccess()) {
			this.employerDao.save(employer);
			verificationService.sendVerificationCode(employer.getEmail());
		    return new SuccessResult("İşveren sisteme eklendi ve e-postaya doğrulama kodu gönderildi. Lütfen emailinizi kontrol edin");
			
		}
		
		return result;
	}
	
	
	private Result nullControl(Employer employer) {
		if (Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getEmail()) 
				|| Objects.isNull(employer.getId()) || Objects.isNull(employer.getPassword()) 
				|| Objects.isNull(employer.getPhoneNumber()) || Objects.isNull(employer.getWebAddress())) {
			return new ErrorResult("bu alanlar boş bırakılamaz.");
		}
		return new SuccessResult();
	}


	@Override
	public DataResult<List<Employer>> getByEmail(String email) {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByEmail(email));
	}


	private Result existEmail(String email) {
		if (this.employerDao.getByEmail(email).stream().count() !=0) {
			return new ErrorResult("böyle bir email zaten kayıtlı.");
		}
		return new SuccessResult();
	}
	
	private Result webAddressDomainControl(String webAddress, String email) {
		String emailSplit= email.split("@")[1];
		
		if (!webAddress.contains(emailSplit)) {
			return new ErrorResult("email,web sitesi ile aynı domaine sahip olmalıdır.");
		}
		return new SuccessResult();
	}
	
	private Result isRealPhoneNumber(String phoneNumber) {
		String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		
		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(phoneNumber);
		if (!matcher.matches()) {
			return new ErrorResult("Geçersiz Telefon Numarası");
		}
		return new SuccessResult();

	}
	
	
	

}
