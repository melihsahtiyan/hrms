package melih.hrms.dataAccess.abstracts;

import melih.hrms.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CvDao extends JpaRepository<Cv, Integer> {

    public List<Cv> getAllBySchool_SchoolName(String schoolName);

    public List<Cv> getByOrderByGraduationDate();

    public List<Cv> getByOrderByGraduationDateDesc();

    public List<Cv> getByOrderByGraduationDateAsc();

    public List<Cv> getAllByAbility_Description(String description);

}
