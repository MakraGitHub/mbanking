package co.edu.mbk.api.file.web;

import co.edu.mbk.api.file.FileService;
import co.edu.mbk.base.BaseApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@Slf4j
@RequiredArgsConstructor
public class FileRestController {

    private final FileService fileService;
    @PostMapping
    public BaseApi<?> uploadSingle(@RequestPart("file") MultipartFile file){
        log.info("Request file upload = {}",file);
        FileDto fileDto = fileService.uploadSingle(file);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("File has been uploaded")
                .timestamp(LocalDateTime.now())
                .data(fileDto)
                .build();
    }
    @PostMapping("/multiple")
    public BaseApi<?> uploadMutiple(@RequestPart("files") List<MultipartFile> files){
        log.info("Request file upload ={}",files);
        List<FileDto> filesDto = fileService.uploadMultiple(files);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Files have been upload")
                .timestamp(LocalDateTime.now())
                .data(filesDto)
                .build();
    }


}
