package melih.hrms.dataAccess.abstracts;

import melih.hrms.entities.concretes.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectorDao extends JpaRepository<Sector, Integer> {
}
