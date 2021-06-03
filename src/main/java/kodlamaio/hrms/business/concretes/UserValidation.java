package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.UserDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {

    public static Result emailNullValidator(UserDto userDto) {
        if (userDto.getEmail().isBlank() || userDto.getEmail() == null) {
            return new ErrorResult("lutfen epostanizi girniz bos alan birakmayin");
        }
        return new SuccessResult();
    }

    public static Result passwordNullValidator(UserDto userDto) {
        if (userDto.getPassword().isBlank() || userDto.getPassword() == null) {
            return new ErrorResult("Sifre alani bos birakilamaz");
        }
        return new SuccessResult();
    }
    public  static Result passwordIsVerified(UserDto userDto){
        if(!userDto.getPassword().equals(userDto.getVerifyPassword())){

            return new ErrorResult("Sifre ile tekrari uyusmuyor");
        }
        return new SuccessResult();
    }

    public  static Result emailIsVerified(UserDto userDto){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(userDto.getEmail());
        if(matcher.matches()){
            return new SuccessResult();
        }
        return new ErrorResult("Eposta formati dogru deyil");
    }


}
