package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.JobAdvertisement;

import java.util.Date;
import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> getAllByJobPosition(String jobPositionName);

    DataResult<List<JobAdvertisement>> getAllByCity(String city);

    DataResult<List<JobAdvertisement>> getAllActive();

    DataResult<List<JobAdvertisement>> getAllByEmployer_CompanyNameAndStatus(String companyName);

    DataResult<List<JobAdvertisement>> getAllSortedByNeededEmployee();

    DataResult<List<JobAdvertisement>> getAllBySalaryBetween(int min,int max);

    DataResult<List<JobAdvertisement>> getByOrderByReleaseDate();

    DataResult<List<JobAdvertisement>> getByOrderByExpirationDate();

    Result add(JobAdvertisement jobAdvertisement);

    Result deactivate(JobAdvertisement jobAdvertisement);
}
