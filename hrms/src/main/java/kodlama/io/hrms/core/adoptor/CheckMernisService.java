package kodlama.io.hrms.core.adoptor;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface CheckMernisService {
	boolean checkIfRealTcNo(Candidate candidate);
}
