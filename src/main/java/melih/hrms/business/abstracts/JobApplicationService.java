package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationService {

   Result add(JobApplication jobApplication);

   DataResult<List<JobApplication>> getAllByJobSeeker_JobSeekerId(int jobSeekerId);

   DataResult<List<JobApplication>> getAll();

}
