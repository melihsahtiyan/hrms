package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.SystemStaff;

import java.util.List;

public interface SystemStaffService {

    Result add(SystemStaff systemStaff);

    DataResult<List<SystemStaff>> getAll();

}
