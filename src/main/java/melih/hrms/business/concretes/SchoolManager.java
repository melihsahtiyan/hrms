package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.SchoolService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.dataAccess.abstracts.SchoolDao;
import melih.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<School>> getAllBySchoolNameContainsAndDepartmentContains(String schoolName, String department) {
        return new SuccessDataResult<List<School>>(this.schoolDao.getAllBySchoolNameContainsAndDepartmentContains(schoolName, department));
    }

    @Override
    public DataResult<List<School>> getAllBySchoolNameContainsOrDepartmentContains(String schoolName, String department) {
        return new SuccessDataResult<List<School>>(this.schoolDao.getAllBySchoolNameContainsOrDepartmentContains(schoolName,department));
    }

    @Override
    public DataResult<List<School>> getAllBySchoolNameContains(String schoolName) {
        return new SuccessDataResult<List<School>>(this.schoolDao.getAllBySchoolNameContains(schoolName));
    }

    @Override
    public DataResult<List<School>> getAllByDepartmentContains(String department) {
        return new SuccessDataResult<List<School>>(this.schoolDao.getAllByDepartmentContains(department));
    }
}
