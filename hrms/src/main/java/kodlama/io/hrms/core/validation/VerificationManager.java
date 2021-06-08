package kodlama.io.hrms.core.validation;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationManager implements VerificationService{

	//Mail onayı yapılırken, mail onaylanırsa random bir kod üretiyor.
	@Override
	public boolean sendVerificationCode(String email) {
		UUID uuid = UUID.randomUUID();
	    String code= uuid.toString();
		System.out.println(email +" mailine kod gönderildi. Doğrulama kodu:" + code );
		return true;
	}
	
}
