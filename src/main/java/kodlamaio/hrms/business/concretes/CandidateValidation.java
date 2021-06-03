package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.CandidateDao;
import kodlamaio.hrms.entities.dtos.CandidateDto;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CandidateValidation {

    public static Result firstNameValidator(CandidateDto candidateDto) {
        if (candidateDto.getFirstName().isBlank() || candidateDto.getFirstName() == null) {
            return new ErrorResult("Isim alani bos olmaz lutfen doldurun");

        }
        return new SuccessResult();
    }

    public static Result lastNameValidator(CandidateDto candidateDto) {
        if (candidateDto.getLastName().isBlank() || candidateDto.getLastName() == null) {
            return new ErrorResult("Soyisim alaniniz bos olmaz lutfen doldurun");
        }
        return new SuccessResult();
    }

    public static Result birthDateValidator(CandidateDto candidateDto) {
        if (candidateDto.getBirthOfDate() == null) {
            return new ErrorResult("Tarih bos birakilamaz");
        }
        return new SuccessResult();
    }



    public static Result IdentityValidator(CandidateDto candidateDto) {
        if (candidateDto.getIdentityNumber().isBlank() || candidateDto.getIdentityNumber() == null) {
            return new ErrorResult("Tc kimlik numarasi alani bos lutfen Tc kimlik alanini doldurun");
        }

        return new SuccessResult();
    }


    public  static Result findEmail(CandidateDto candidateDto, CandidateDao candidateDao){
        if(candidateDao.findByEmail(candidateDto.getEmail()).size() == 0){
            return new SuccessResult();
        }
        return new ErrorResult("eposta zaten kayitli");
    }


    public static Result findIdentity(CandidateDto candidateDto, CandidateDao candidateDao){
        if(candidateDao.findByIdentityNumber(candidateDto.getIdentityNumber()).size() == 0){
            return new SuccessResult();
        }
        return new ErrorResult("tc kimlik numarasi sistemde kayitli");
    }


    public static Result compareFormat(CandidateDto candidateDto) {
        String inputValue = candidateDto.getBirthOfDate();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        try {
            format.parse(inputValue);
            // parsing succeeded; so the format seems to match
            return new SuccessResult();
        } catch (DateTimeParseException dtpe) {
            return new ErrorResult("tarih formati yanlis lutfen formati 'YYYY-MM-DD' seklinde yazin");
        }
    }
}
