package com.athisii.exception;

import com.athisii.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author athisii
 * @version 1.0
 * @since 05/02/23
 */

@Slf4j
@RestControllerAdvice
@ResponseStatus(HttpStatus.OK)
public class AppExceptionHandler {

    @ExceptionHandler({GenericException.class, RuntimeException.class})
    public ResponseDto<Object> genericExceptionHandler(RuntimeException exception) {
        String message = exception.getMessage();
        log.error("Exception thrown:: " + message);
        return ResponseDto.onFail(message);
    }

}
