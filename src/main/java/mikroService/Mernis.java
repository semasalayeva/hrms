package mikroService;


import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.dtos.CandidateDto;

public class Mernis {
   public Result isIdentity(CandidateDto candidateDto){
       if(candidateDto.getIdentityNumber().length()==11){
           return new SuccessResult();

       }
           return new ErrorResult("tc kimlik numarasi dogru deyil tc kimlik numarasi 11 rakamdan az olamaz");
    }
}
