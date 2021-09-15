package melih.hrms.api.controllers;

import melih.hrms.business.abstracts.EmployerService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService){
        this.employerService=employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer) {
        return this.employerService.add(employer);
    }

}