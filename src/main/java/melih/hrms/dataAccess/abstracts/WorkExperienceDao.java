package melih.hrms.dataAccess.abstracts;

import melih.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {

    public List<WorkExperience> getByOrderByEndingYear();

}
