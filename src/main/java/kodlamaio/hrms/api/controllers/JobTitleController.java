package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.busniess.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle) {
        return jobTitleService.add(jobTitle);
    }

}

