package melih.hrms.api.controllers;

import melih.hrms.business.abstracts.WorkExperienceService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workExperiences")
public class WorkExperincesController {

    private WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperincesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @PostMapping("/add")
    Result add(@RequestBody WorkExperience workExperience){
        return this.workExperienceService.add(workExperience);
    }

    @GetMapping("/getall")
    DataResult<List<WorkExperience>> getAll(){
        return this.workExperienceService.getAll();
    }

    @GetMapping("/getByOrderByEndingYear")
    DataResult<List<WorkExperience>> getByOrderByEndingYear(){
        return this.workExperienceService.getByOrderByEndingYear();
    }
}
