package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.SectorService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.dataAccess.abstracts.SectorDao;
import melih.hrms.entities.concretes.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorManager implements SectorService {

    private SectorDao sectorDao;

    @Autowired
    public SectorManager(SectorDao sectorDao) {
        this.sectorDao = sectorDao;
    }

    @Override
    public Result add(Sector sector) {
        this.sectorDao.save(sector);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Sector>> getAll() {
        return new SuccessDataResult<List<Sector>>(this.sectorDao.findAll());
    }
}
