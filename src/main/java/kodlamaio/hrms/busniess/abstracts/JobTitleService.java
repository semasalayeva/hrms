package kodlamaio.hrms.busniess.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
   List<JobTitle> getAll();
   Result add(JobTitle jobTitle);
}
