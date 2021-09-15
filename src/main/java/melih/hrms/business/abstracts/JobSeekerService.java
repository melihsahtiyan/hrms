package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    DataResult<List<JobSeeker>> getAll();

    DataResult<JobSeeker> getByIdentityNumber(String identityNumber);

    Result add(JobSeeker jobSeeker);

    DataResult<List<JobSeeker>> getAllBySortedAsc();

    DataResult<List<JobSeeker>> getAllByJobPosition_JobPositionName(String jobPositionName);

    DataResult<JobSeeker> getByJobSeekerId(int jobSeekerId);
}