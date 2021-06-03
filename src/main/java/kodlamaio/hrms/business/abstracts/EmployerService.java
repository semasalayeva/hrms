package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerDto;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result add(EmployerDto employer);

}
