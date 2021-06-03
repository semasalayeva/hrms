package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class EmailConfirm implements EmailService {
    @Override
    public Result send(VerificationCode verificationCode) {
//        verificationCode.setCode(rndChar());
        return new SuccessResult("sisteme giris tamamlandi lutfen epostanizi dogrulayin");
    }

    @Override
    public void confirm(VerificationCode verificationCode) {
           if(verificationCode.getCode().equals(rndChar())){
               verificationCode.setVerified(true);
               verificationCode.setVerifiedData(LocalDate.now());
               System.out.println("epostaniz dogrulanmisdir");
           }
    }

    private  String rndChar () {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;

    }

}
