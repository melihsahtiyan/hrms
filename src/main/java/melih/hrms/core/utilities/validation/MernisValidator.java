package melih.hrms.core.utilities.validation;

import melih.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class MernisValidator implements ValidationService<JobSeeker> {

    @Override
    public void Validate(JobSeeker jobSeeker) {
        jobSeeker.setStatus(true);
    }
}