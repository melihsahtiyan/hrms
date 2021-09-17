package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.Cv;

import java.util.List;

public interface CvService {

    public Result add(Cv cv);

    DataResult<List<Cv>> getAll();

    public DataResult<List<Cv>> getAllBySchool_SchoolName(String schoolName);

    public DataResult<List<Cv>> getByOrderByGraduationDate();

    public DataResult<List<Cv>> getByOrderByGraduationDateDesc();

    public DataResult<List<Cv>> getByOrderByGraduationDateAsc();

    public DataResult<List<Cv>> getAllByAbility_Description(String description);

}
