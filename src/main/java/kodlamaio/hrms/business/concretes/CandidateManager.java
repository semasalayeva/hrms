package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.abstracts.EmailService;
import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAcces.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private EmailService emailService;
    private MernisService mernisService;


    @Autowired
    public CandidateManager(CandidateDao candidateDao, EmailService emailService, MernisService mernisService) {
        this.candidateDao = candidateDao;
        this.emailService = emailService;
        this.mernisService = mernisService;
    }


    @Override
    public DataResult<List<Candidate>> getAll() {

        return new SuccessDataResult<>(candidateDao.findAll());
    }

    @Override
    public Result add(CandidateDto candidateDto) {
        VerificationCode verificationCode = new VerificationCode();
        Result[] results = {CandidateValidation.findIdentity(candidateDto, candidateDao),
                CandidateValidation.findEmail(candidateDto, candidateDao)
                , UserValidation.emailIsVerified(candidateDto)
                , UserValidation.passwordIsVerified(candidateDto)
                , CandidateValidation.birthDateValidator(candidateDto)
                , CandidateValidation.firstNameValidator(candidateDto)
                , CandidateValidation.IdentityValidator(candidateDto)
                , CandidateValidation.lastNameValidator(candidateDto)
                , UserValidation.passwordNullValidator(candidateDto)
                , UserValidation.emailNullValidator(candidateDto)
                , mernisService.isIdentity(candidateDto)
                , CandidateValidation.compareFormat(candidateDto)};
        Result result = BusinessResult.run(results);
        if (!result.isSuccess()) {
            return new ErrorDataResult<>(result.getMessage());
        }
        Candidate candidate = new Candidate(candidateDto.getEmail(), candidateDto.getPassword(),
                candidateDto.getFirstName(), candidateDto.getLastName(),
                LocalDate.parse(candidateDto.getBirthOfDate()), candidateDto.getIdentityNumber());

        candidateDao.save(candidate);
        emailService.send(verificationCode);
        return new SuccessDataResult<>(candidate,"Sisteme kayd gerceklesdi lutfen epostanizi dogrulayin");

    }
}
