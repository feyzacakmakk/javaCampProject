package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.business.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.User;


@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"data listelendi.");
	}

	@Override
	public Result add(User user) {
		Result result=BusinessRules.run(nullcontrol(user),emailFormatCheck(user.getEmail()));
		
		if (result.isSuccess()) {
			this.userDao.save(user);
			return new SuccessResult("kullanıcı eklendi.");
		}
		return new ErrorResult();
	}                                                                  

	@Override
	public DataResult<List<User>> getById(int id) {
		
		return new SuccessDataResult<List<User>>(this.userDao.getById(id));
	}

	@Override
	public DataResult<List<User>> getByEmail(String email) {
		
		return new SuccessDataResult<List<User>>(this.userDao.getByEmail(email));
	}
	
	private Result nullcontrol(User user) {
		if (Objects.isNull(user.getId()) || Objects.isNull(user.getEmail())|| Objects.isNull(user.getPassword())) {
			return new ErrorResult("bu alanlar boş bırakılamaz");
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
