package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.entities.concretes.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();

    Result add(User user);

    DataResult<User> getUserByEmail(String email);

    Result delete(User user);
}