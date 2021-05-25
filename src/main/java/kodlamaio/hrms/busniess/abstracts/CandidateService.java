package kodlamaio.hrms.busniess.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;


import java.util.List;

public interface CandidateService {
    List<Candidate> getAll();
    Result add(Candidate candidate);
}
