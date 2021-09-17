package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {

    Result add(School school);

    DataResult<List<School>> getAllBySchoolNameContainsAndDepartmentContains(String schoolName, String department);


    DataResult<List<School>> getAllBySchoolNameContainsOrDepartmentContains(String schoolName, String department);


    DataResult<List<School>> getAllBySchoolNameContains(String schoolName);


    DataResult<List<School>> getAllByDepartmentContains(String department);

}
