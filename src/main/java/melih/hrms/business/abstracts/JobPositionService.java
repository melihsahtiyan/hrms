package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {

    Result add(JobPosition jobPosition);

    Result delete(JobPosition jobPosition);

    DataResult<List<JobPosition>> getAll();

    DataResult<List<JobPosition>> getAllSortedAsc();


}