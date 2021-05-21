package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
}
