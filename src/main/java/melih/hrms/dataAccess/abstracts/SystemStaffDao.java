package melih.hrms.dataAccess.abstracts;

import melih.hrms.entities.concretes.SystemStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemStaffDao extends JpaRepository<SystemStaff, Integer> {
}
