package melih.hrms.api.controllers;

import melih.hrms.business.abstracts.JobSeekerService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekersController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService){
        this.jobSeekerService=jobSeekerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobSeeker>> getAll(){
        return this.jobSeekerService.getAll();
    }

    @GetMapping("/getByIdentityNumber")
    public DataResult<JobSeeker> getByIdentityNumber(@RequestParam String identityNumber){
        return this.jobSeekerService.getByIdentityNumber(identityNumber);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobSeeker jobSeeker){
        return this.jobSeekerService.add(jobSeeker);
    }

}