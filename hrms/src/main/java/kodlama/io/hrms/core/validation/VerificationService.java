package kodlama.io.hrms.core.validation;

public interface VerificationService {
	boolean sendVerificationCode(String email);
}
