package melih.hrms.dataAccess.abstracts;

import melih.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
    List<JobPosition> getByJobPositionNameContains(String jobPositionName);
}