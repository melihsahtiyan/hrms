package melih.hrms.dataAccess.abstracts;

import melih.hrms.entities.concretes.JobAdvertisement;
import melih.hrms.entities.concretes.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    List<JobAdvertisement> getAllByJobPosition_JobPositionName(String jobPositionName);

    List<JobAdvertisement> getAllByCity(String city);

    List<JobAdvertisement> getAllByStatus(boolean status);

    List<JobAdvertisement> getAllByEmployer_CompanyNameAndStatus(String companyName, boolean status);

    List<JobAdvertisement> getByOrderByReleaseDate();

    List<JobAdvertisement> getByOrderByReleaseDateAsc();


    List<JobAdvertisement> getByOrderByReleaseDateDesc();

    List<JobAdvertisement> getByOrderByExpirationDate();

    List<JobAdvertisement> getByOrderByExpirationDateAsc();

    List<JobAdvertisement> getByOrderByExpirationDateDesc();

    @Query("from JobAdvertisement where salary<:max and salary>:min")
    List<JobAdvertisement> getAllBySalaryBetween(int min,int max);
}
