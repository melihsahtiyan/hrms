package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.WorkExperience;

import java.util.List;

public interface WorkExperienceService {

    Result add(WorkExperience workExperience);

    DataResult<List<WorkExperience>> getAll();

    DataResult<List<WorkExperience>> getByOrderByEndingYear();
}
