package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.EmployerService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.dataAccess.abstracts.EmployerDao;
import melih.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService{

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao){
        this.employerDao=employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi");
    }

    @Override
    public Result add(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult("İş veren eklendi");
    }
}