package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.UserService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.core.dataAccess.UserDao;
import melih.hrms.core.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    //private ValidationService emailValidator;
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao/*, ValidationService<User> validationService*/) {
        super();
        //this.emailValidator=validationService;
        this.userDao = userDao;
    }


    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Kullanıcılar listelendi") ;
    }

    @Override
    public Result add(User user) {
        //this.emailValidator.Validate(user);
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> getUserByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getUserByEmail(email),email + " e-postasına ait kullanıcı sistemimizde mevcuttur.");
    }

    @Override
    public Result delete(User user) {
        this.userDao.delete(user);
        return new SuccessResult("Kullanıcı silindi");
    }

}