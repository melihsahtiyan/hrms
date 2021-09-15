package melih.hrms.core.dataAccess;

import melih.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User getUserByEmail(String email);
}