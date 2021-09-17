package melih.hrms.api.controllers;

import melih.hrms.business.abstracts.JobApplicationService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobApplications")
public class JobApplicationsController {

    private JobApplicationService jobApplicationService;

    @Autowired
    public JobApplicationsController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping("/add")
    Result add(@RequestBody JobApplication jobApplication){
        return this.jobApplicationService.add(jobApplication);
    }

    @GetMapping("/getAllByJobSeeker_JobSeekerId")
    DataResult<List<JobApplication>> getAllByJobSeeker_JobSeekerId(int jobSeekerId){
        return this.jobApplicationService.getAllByJobSeeker_JobSeekerId(jobSeekerId);
    }

    @GetMapping("/getAll")
    DataResult<List<JobApplication>> getAll(){
        return this.jobApplicationService.getAll();
    }
}
