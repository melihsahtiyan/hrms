package melih.hrms.core.adapters.concretes;


import java.io.IOException;
import java.util.Map;

import melih.hrms.core.adapters.abstracts.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.ErrorDataResult;
import melih.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryServiceAdapter implements CloudinaryService {
    private Cloudinary cloudinary;

    public CloudinaryServiceAdapter() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dhewspkhn",
                "api_key", "228429263945839",
                "api_secret" , "Wb0K6FYcg1MHLzGUN_oK6MKMtiU"
        ));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public DataResult<Map> uploadImage(MultipartFile imageFile) {
        try {
            Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());

            return new SuccessDataResult<>(resultMap);

        }
        catch (IOException exception) {
            exception.printStackTrace();

        }
        return new ErrorDataResult<Map>();
    }

}
