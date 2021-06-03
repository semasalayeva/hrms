package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateDto;

public interface MernisService {
    Result isIdentity(CandidateDto candidateDto);
}
