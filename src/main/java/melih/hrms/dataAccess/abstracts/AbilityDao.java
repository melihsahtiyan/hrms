package melih.hrms.dataAccess.abstracts;

import melih.hrms.entities.concretes.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbilityDao extends JpaRepository<Ability, Integer> {

    public List<Ability> getAllByDescriptionContains(String descrpition);
}
