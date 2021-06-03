package kodlamaio.hrms.core.utilities.results;

public class BusinessResult {
    public static Result run(Result[] results){
        for (Result result: results) {
            if(!result.isSuccess()){
                return result;
            }
        }
        return new SuccessResult();
    }
}
