package co.edu.mbk.api.file;

import co.edu.mbk.api.file.web.FileDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    FileDto uploadSingle(MultipartFile file);
    List<FileDto> uploadMultiple(List<MultipartFile> files);

    void deleteFile(String name);

    FileDto findByName(String name) throws IOException;

    Resource download(String name);

}
