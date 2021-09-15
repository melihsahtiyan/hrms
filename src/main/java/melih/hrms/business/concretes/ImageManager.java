package melih.hrms.business.concretes;

import melih.hrms.business.abstracts.ImageService;
import melih.hrms.core.adapters.abstracts.CloudinaryService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.core.utilities.results.SuccessDataResult;
import melih.hrms.core.utilities.results.SuccessResult;
import melih.hrms.dataAccess.abstracts.ImageDao;
import melih.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ImageManager implements ImageService {

    private CloudinaryService cloudinaryService;
    private ImageDao imageDao;

    @Autowired
    public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService){
        this.imageDao=imageDao;
        this.cloudinaryService=cloudinaryService;
    }

    @Override
    public Result add(Image image, MultipartFile multipartFile) {
        Map<String,String> imageUpload = this.cloudinaryService.uploadImage(multipartFile).getData();
        image.setUrl(imageUpload.get("url"));
        this.imageDao.save(image);
        return new SuccessResult();
    }

    @Override
    public Result delete(Image image) {
        this.imageDao.deleteByImageId(image.getImageId());
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
    }

    @Override
    public DataResult<List<Image>> getAllByJobSeeker_JobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<List<Image>>(this.imageDao.getAllByJobSeeker_JobSeekerId(jobSeekerId));
    }
}
