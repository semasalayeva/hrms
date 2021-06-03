package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployerValidation {

    public static Result companyNameNullValidate(EmployerDto employerDto) {
        if (employerDto.getCompanyName().isBlank() || employerDto.getCompanyName() == null) {
            return new ErrorResult("Sirket isim alani bos olmaz lutfen doldurun");

        }
        return new SuccessResult();
    }

    public static Result phoneNumberNullValidate(EmployerDto employerDto) {
        if (employerDto.getPhoneNumber().isBlank() || employerDto.getPhoneNumber() == null) {
            return new ErrorResult("Numara alani bos lutfen telefon numaranizi giriniz");

        }
        return new SuccessResult();
    }

    public static Result webSiteNullValidate(EmployerDto employerDto) {
        if (employerDto.getWebSite().isBlank() || employerDto.getWebSite() == null) {
            return new ErrorResult("web sayt alani bos birakilamaz lutfen doldurun");

        }
        return new SuccessResult();
    }


    public static Result emailWebSiteIsVerified(EmployerDto employerDto){
       String emailSpilt = employerDto.getEmail().split("@")[1];
       if(employerDto.getWebSite().contains(emailSpilt)){
           return new SuccessResult();
       }
       return new ErrorResult("e-postaniz web sitesi ile aynı domaine sahip deyil");

    }















}
