package melih.hrms.core.adapters.abstracts;

import melih.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

public interface CloudinaryService {
    @SuppressWarnings("rawtypes")
    public DataResult<Map> uploadImage(MultipartFile imageFile);
}
