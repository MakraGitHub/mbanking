package co.edu.mbk.exception;

import co.edu.mbk.base.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class FileException {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    BaseError<?>  handleMaxUploadSize(MaxUploadSizeExceededException e){
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Something went wrong, Please check again.")
                .timestamp(LocalDateTime.now())
                .errors(e.getMessage())
                .build();
    }

}
