package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import mikroService.Mernis;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements MernisService {

    @Override
    public Result isIdentity(CandidateDto candidateDto) {
        Mernis mernis = new Mernis();
        return mernis.isIdentity(candidateDto);
    }
}
