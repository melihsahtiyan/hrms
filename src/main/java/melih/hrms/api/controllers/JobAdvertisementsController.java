package melih.hrms.api.controllers;

import melih.hrms.business.abstracts.JobAdvertisementService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService=jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getallbyjobposition")
    public DataResult<List<JobAdvertisement>> getAllByJobPosition(@RequestParam String jobPositionName){
        return this.jobAdvertisementService.getAllByJobPosition(jobPositionName);
    }

    @GetMapping("/getallbycity")
    public DataResult<List<JobAdvertisement>> getAllByCity(@RequestParam String city){
        return this.jobAdvertisementService.getAllByCity(city);
    }

    @GetMapping("/getallactive")
    public DataResult<List<JobAdvertisement>> getAllActive(){
        return this.jobAdvertisementService.getAllActive();
    }

    @GetMapping("/getallsortedneededemployee")
    public DataResult<List<JobAdvertisement>> getAllSortedByNeededEmployee(){
        return this.jobAdvertisementService.getAllSortedByNeededEmployee();
    }

    @GetMapping("/getallbysalarybetween")
    public DataResult<List<JobAdvertisement>> getAllBySalaryBetween(@RequestParam("min") int min,@RequestParam("max") int max){
        return this.jobAdvertisementService.getAllBySalaryBetween(min, max);
    }

    @GetMapping("/getByOrderByReleaseDate")
    public DataResult<List<JobAdvertisement>> getByOrderByReleaseDate(){
        return this.jobAdvertisementService.getByOrderByReleaseDate();
    }

    @GetMapping("/getByOrderByExpirationDate")
    public DataResult<List<JobAdvertisement>> getByOrderByExpirationDate(){
        return this.jobAdvertisementService.getByOrderByExpirationDate();
    }

    @GetMapping("/getallbycompanyname")
    public DataResult<List<JobAdvertisement>> getAllByEmployer_CompanyNameAndStatus(String companyName){
        return this.jobAdvertisementService.getAllByEmployer_CompanyNameAndStatus(companyName);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @PostMapping("/deactivate")
    public Result deactivate(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.deactivate(jobAdvertisement);
    }

}
