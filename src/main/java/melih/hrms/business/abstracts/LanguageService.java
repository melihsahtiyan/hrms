package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.Language;

import java.util.List;

public interface LanguageService {

    Result add(Language language);

    DataResult<List<Language>> getByOrderByLevelAsc();

    DataResult<List<Language>> getAll();

}
