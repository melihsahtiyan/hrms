package melih.hrms.api.controllers;


import melih.hrms.business.abstracts.JobPositionService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private JobPositionService service;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.service = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return service.getAll();
    }

    @GetMapping("/getallsortedasc")
    public DataResult<List<JobPosition>> getAllSortedAsc(){
        return service.getAllSortedAsc();
    }

    @PostMapping(value="/add")
    public Result add(@Valid @RequestBody JobPosition jobPosition){
        return this.service.add(jobPosition);
    }

}