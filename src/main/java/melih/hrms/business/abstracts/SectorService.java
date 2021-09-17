package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.Sector;

import java.util.List;

public interface SectorService {

    Result add(Sector sector);

    DataResult<List<Sector>> getAll();

}
