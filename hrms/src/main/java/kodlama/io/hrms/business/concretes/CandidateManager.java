package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlama.io.hrms.business.abstracts.CandidateService;

import kodlama.io.hrms.core.business.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;

	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		this.candidateDao=candidateDao;
		
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "iş arayanlar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		
		Result result= BusinessRules.run(CheckidentityNumber(candidate), 
				nullControl(candidate),tcExist(candidate.getIdentityNumber()), 
				emailExist(candidate.getEmail()), emailFormatCheck(candidate.getEmail()));
		
		if (result.isSuccess()) {
			
			this.candidateDao.save(candidate);
			return new SuccessResult(candidate.getFirstName()+" "+candidate.getLastName()+ " iş arayan eklendi");
		}
		
		return result;
		/*if (!ExistMail(candidate.getEmail())) {
			return new ErrorResult("böyle bir email var.");
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult(candidate.getFirstName()+" "+candidate.getLastName()+ " iş arayan eklendi");*/
		
	}
	
	/*private boolean ExistMail(String email) {
		if (candidateDao.getByEmail(email) !=null) {
			return false;
		}
		return true;
	}*/

	
	private Result CheckidentityNumber(Candidate candidate) {

		if (candidate.getIdentityNumber().length() != 11) {
			return new ErrorResult("Tc numarası 11 haneli olmalıdır!");
		}
		return new SuccessResult();
	}

	private Result nullControl(Candidate candidate) {
		if (Objects.isNull(candidate.getBirthYear())   
				||  Objects.isNull(candidate.getEmail()) 
				|| Objects.isNull(candidate.getId()) 
				|| Objects.isNull(candidate.getFirstName()) 
				|| Objects.isNull(candidate.getIdentityNumber())
				|| Objects.isNull(candidate.getLastName())
				|| Objects.isNull(candidate.getPassword())) {

			return new ErrorResult("Bu alanlar boş bırakılamaz!");
		}
		
		return new SuccessResult();
	}
	
	private Result tcExist(String identityNumber) {
		if (candidateDao.getByIdentityNumber(identityNumber).stream().count()!= 0) {
			return new ErrorResult("girdiğiniz tc mevcut");
		}
		
		return new SuccessResult();
	}
	
	
	
	private Result emailExist(String email) {
		
		if (candidateDao.getByEmail(email).stream().count()!=0) {
			return new ErrorResult("bu email zaten kayıtlı.");
		}
		return new SuccessResult();
	}
	
	
	public static final Pattern validEmail = Pattern.compile(
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$",
			Pattern.CASE_INSENSITIVE);

	private Result emailFormatCheck(String email) {
		if (!validEmail.matcher(email).find()) {
			return new ErrorResult("Geçerli bir mail adresi girin!");
		}
		return new SuccessResult();
	}

	
	
}
