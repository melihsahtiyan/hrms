package melih.hrms.dataAccess.abstracts;

import melih.hrms.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDao extends JpaRepository<Image, Integer> {

    public List<Image> getAllByJobSeeker_JobSeekerId(int jobSeekerId);

    public void deleteByImageId(int imageId);

}
