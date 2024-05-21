package co.edu.mbk.api.file;

import co.edu.mbk.api.file.web.FileDto;
import co.edu.mbk.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{
    private FileUtil fileUtil;
    @Autowired
    public void setFileUtil(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }
    @Override
    public FileDto uploadSingle(MultipartFile file) {
        //Copy upload file to server
        return fileUtil.upload(file);
    }
    @Override
    public List<FileDto> uploadMultiple(List<MultipartFile> files) {
        List<FileDto> filesDto = new ArrayList<>();
        for(MultipartFile file: files){
            FileDto fileDto = fileUtil.upload(file);
             filesDto.add(fileDto);
        }
        return filesDto;
    }
}
