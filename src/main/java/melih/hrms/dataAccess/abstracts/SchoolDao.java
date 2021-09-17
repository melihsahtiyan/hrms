package melih.hrms.dataAccess.abstracts;

import melih.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolDao extends JpaRepository<School, Integer> {

    List<School> getAllBySchoolNameContainsAndDepartmentContains(String schoolName, String department);


    List<School> getAllBySchoolNameContainsOrDepartmentContains(String schoolName, String department);


    List<School> getAllBySchoolNameContains(String schoolName);


    List<School> getAllByDepartmentContains(String department);

}
