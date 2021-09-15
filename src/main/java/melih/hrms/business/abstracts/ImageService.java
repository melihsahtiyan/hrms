package melih.hrms.business.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.Image;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    public Result add(Image image, MultipartFile multipartFile);

    public Result delete(Image image);

    public DataResult<List<Image>> getAll();

    public DataResult<List<Image>> getAllByJobSeeker_JobSeekerId(int jobSeekerId);

}
