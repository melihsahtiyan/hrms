package melih.hrms.api.controllers;

import melih.hrms.business.abstracts.CvService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.Cv;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {

    private CvService cvService;

    public CvsController(CvService cvService){
        this.cvService=cvService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Cv cv){
        return this.cvService.add(cv);
    }

    @GetMapping("/getAllBySchool_SchoolName")
    public DataResult<List<Cv>> getAllBySchool_SchoolName(@RequestParam String schoolName){
        return this.cvService.getAllBySchool_SchoolName(schoolName);
    }

    @GetMapping("/getByOrderByGraduationDate")
    public DataResult<List<Cv>> getByOrderByGraduationDate(){
        return this.cvService.getByOrderByGraduationDate();
    }

    @GetMapping("/getByOrderByGraduationDateDesc")
    public DataResult<List<Cv>> getByOrderByGraduationDateDesc(){
        return this.cvService.getByOrderByGraduationDateDesc();
    }

    @GetMapping("/getByOrderByGraduationDateAsc")
    public DataResult<List<Cv>> getByOrderByGraduationDateAsc(){
        return this.cvService.getByOrderByGraduationDateAsc();
    }

    @GetMapping("/getAllByAbility_Description")
    public DataResult<List<Cv>> getAllByAbility_Description(@RequestParam String description){
        return this.cvService.getAllByAbility_Description(description);
    }


}
