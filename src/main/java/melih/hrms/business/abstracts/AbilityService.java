package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.Ability;

import java.util.List;

public interface AbilityService {

    Result add(Ability ability);

    DataResult<List<Ability>> getAll();

    DataResult<List<Ability>> getAllByDescriptionContains(String descrpition);

}
