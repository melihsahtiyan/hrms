package melih.hrms.api.controllers;

import melih.hrms.business.abstracts.AbilityService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
public class AbilitiesController {

    private AbilityService abilityService;

    @Autowired
    public AbilitiesController(@RequestParam AbilityService abilityService){
        this.abilityService=abilityService;
    }

    @GetMapping("/getAll")
    DataResult<List<Ability>> getAll(){
        return this.abilityService.getAll();
    }

    @GetMapping("/getAllByDescriptionContains")
    DataResult<List<Ability>> getAllByDescriptionContains(@RequestParam String descrpition){
        return this.abilityService.getAllByDescriptionContains(descrpition);
    }


    @PostMapping("/add")
    Result add(@RequestBody Ability ability){
       return this.abilityService.add(ability);
    }

}
