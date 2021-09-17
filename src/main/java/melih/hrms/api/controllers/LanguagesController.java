package melih.hrms.api.controllers;

import melih.hrms.business.abstracts.LanguageService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    Result add(@RequestBody Language language){
        return this.languageService.add(language);
    }

    @GetMapping("/getByOrderByLevelAsc")
    DataResult<List<Language>> getByOrderByLevelAsc(){
        return this.languageService.getByOrderByLevelAsc();
    }

    @GetMapping("/getAll")
    DataResult<List<Language>> getAll(){
        return this.languageService.getAll();
    }

}
