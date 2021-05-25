package kodlamaio.hrms.busniess.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    List<Employer> getAll();
    Result add(Employer employer);

}
