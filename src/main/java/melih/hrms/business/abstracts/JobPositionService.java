package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();
    Result add(JobPosition jobPosition);
    DataResult<List<JobPosition>> getAllSortedAsc();
}