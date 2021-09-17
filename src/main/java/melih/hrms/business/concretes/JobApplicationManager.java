package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.JobApplicationService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.dataAccess.abstracts.JobApplicationDao;
import melih.hrms.entities.concretes.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationManager implements JobApplicationService {

    private JobApplicationDao jobApplicationDao;

    @Autowired
    public JobApplicationManager(JobApplicationDao jobApplicationDao) {
        this.jobApplicationDao = jobApplicationDao;
    }

    @Override
    public Result add(JobApplication jobApplication) {
        this.jobApplicationDao.save(jobApplication);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobApplication>> getAllByJobSeeker_JobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<List<JobApplication>>(this.jobApplicationDao.getAllByJobSeeker_JobSeekerId(jobSeekerId));
    }

    @Override
    public DataResult<List<JobApplication>> getAll() {
        return new SuccessDataResult<List<JobApplication>>(this.jobApplicationDao.findAll());
    }
}
