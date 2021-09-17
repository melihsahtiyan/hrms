package melih.hrms.dataAccess.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.entities.concretes.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationDao extends JpaRepository<JobApplication, Integer> {

    List<JobApplication> getAllByJobSeeker_JobSeekerId(int jobSeekerId);

}
