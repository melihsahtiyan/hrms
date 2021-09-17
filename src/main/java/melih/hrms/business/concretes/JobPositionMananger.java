package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.JobPositionService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.dataAccess.abstracts.JobPositionDao;
import melih.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionMananger implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionMananger(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
    }

    @Override
    public Result add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("İş pozisyonu eklendi!");
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        this.jobPositionDao.delete(jobPosition);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobPosition>> getAllSortedAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"jobPositionName");
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(sort));
    }
}