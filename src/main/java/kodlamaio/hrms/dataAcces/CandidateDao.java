package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate,Integer>{
   List<Candidate> findByIdentityNumber(String identity);
   List<Candidate> findByEmail(String email);
}
