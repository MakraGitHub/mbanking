package co.edu.mbk.api.file;

import co.edu.mbk.api.file.web.FileDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    FileDto uploadSingle(MultipartFile file);
    List<FileDto> uploadMultiple(List<MultipartFile> files);

}
