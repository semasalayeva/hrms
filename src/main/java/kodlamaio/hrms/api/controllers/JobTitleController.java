package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.busniess.abstracts.JobTitleService;
import kodlamaio.hrms.entities.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobTitleController {
    private JobTitleService jobTitleService;

    @Autowired
    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    List<JobTitle> getAll(){
        return jobTitleService.getAll();
    }

}
