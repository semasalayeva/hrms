package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
    List<Candidate> findAllByIdentityNumber(String identity);
}
