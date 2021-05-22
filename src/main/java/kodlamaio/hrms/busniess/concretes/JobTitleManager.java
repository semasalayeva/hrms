package kodlamaio.hrms.busniess.concretes;

import kodlamaio.hrms.busniess.abstracts.JobTitleService;
import kodlamaio.hrms.dataAcces.JobTitleDao;
import kodlamaio.hrms.entities.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobTitleManager implements JobTitleService {
    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public List<JobTitle> getAll() {
        return jobTitleDao.findAll();
    }
}
