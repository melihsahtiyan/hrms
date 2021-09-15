package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.AbilityService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.dataAccess.abstracts.AbilityDao;
import melih.hrms.entities.concretes.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityManager implements AbilityService {

    private AbilityDao abilityDao;

    @Autowired
    public AbilityManager(AbilityDao abilityDao){
        this.abilityDao=abilityDao;
    }

    @Override
    public Result add(Ability ability) {
        this.abilityDao.save(ability);

        return new SuccessResult();
    }

    @Override
    public DataResult<List<Ability>> getAll() {
        return new SuccessDataResult<List<Ability>>(this.abilityDao.findAll());
    }

    @Override
    public DataResult<List<Ability>> getAllByDescriptionContains(String descrpition) {
        return new SuccessDataResult<List<Ability>>(this.abilityDao.getAllByDescriptionContains(descrpition));
    }
}
