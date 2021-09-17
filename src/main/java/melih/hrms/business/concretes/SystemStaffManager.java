package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.SystemStaffService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.dataAccess.abstracts.SystemStaffDao;
import melih.hrms.entities.concretes.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemStaffManager implements SystemStaffService {

    private SystemStaffDao systemStaffDao;

    @Autowired
    public SystemStaffManager(SystemStaffDao systemStaffDao) {
        this.systemStaffDao = systemStaffDao;
    }

    @Override
    public Result add(SystemStaff systemStaff) {
        this.systemStaffDao.save(systemStaff);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<SystemStaff>> getAll() {
        return new SuccessDataResult<List<SystemStaff>>(this.systemStaffDao.findAll());
    }
}
