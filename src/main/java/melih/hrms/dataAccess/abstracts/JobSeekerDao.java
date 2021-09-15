package melih.hrms.dataAccess.abstracts;

import melih.hrms.entities.concretes.JobPosition;
import melih.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {

    public JobSeeker getJobSeekerByIdentityNumber(String identityNumber);

    public List<JobSeeker> getAllByJobPosition_JobPositionName(String jobPositionName);

    public JobSeeker getByJobSeekerId(int jobSeekerId);
}