package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.JobAdvertisementService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.dataAccess.abstracts.JobAdvertisementDao;
import melih.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao){
        this.jobAdvertisementDao=jobAdvertisementDao;
    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByJobPosition(String jobPositionName) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByJobPosition_JobPositionName(jobPositionName));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByCity(String city) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByCity(city));
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        jobAdvertisement.setStatus(true);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İş ilanı eklendi");
    }

    @Override
    public Result deactivate(JobAdvertisement jobAdvertisement) {
        jobAdvertisement.setStatus(false);
        return new SuccessResult("İş ilanı pasifize edilmiştir");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllActive() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByStatus(true));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByEmployer_CompanyNameAndStatus(String companyName) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getAllByEmployer_CompanyNameAndStatus(companyName,true));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSortedByNeededEmployee() {
        Sort sort = Sort.by(Sort.Direction.ASC,"neededEmployee");
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllBySalaryBetween(int min, int max) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllBySalaryBetween(min, max));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByOrderByReleaseDate() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByOrderByReleaseDate());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByOrderByExpirationDate() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByOrderByExpirationDate());
    }
}
