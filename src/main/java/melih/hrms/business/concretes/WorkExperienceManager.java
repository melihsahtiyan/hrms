package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.WorkExperienceService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.dataAccess.abstracts.WorkExperienceDao;
import melih.hrms.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceManager implements WorkExperienceService {

    private WorkExperienceDao workExperienceDao;

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }

    @Override
    public Result add(WorkExperience workExperience) {
        this.workExperienceDao.save(workExperience);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<WorkExperience>> getAll() {
        return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll());
    }

    @Override
    public DataResult<List<WorkExperience>> getByOrderByEndingYear() {
        return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.getByOrderByEndingYear());
    }
}
