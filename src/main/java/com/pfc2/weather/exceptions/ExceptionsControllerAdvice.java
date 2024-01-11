package com.pfc2.weather.exceptions;

import com.pfc2.weather.service.dto.ErrorResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class ExceptionsControllerAdvice {
    @ExceptionHandler({FeignException.class})
    public ResponseEntity<ErrorResponse> feignException(FeignException exception) {
        log.error(exception.getLocalizedMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND, List.of("No information found.")),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error(exception.getLocalizedMessage());
        var errors = Arrays.stream(Objects.requireNonNull(exception.getDetailMessageArguments())).map(Object::toString)
                .filter(s -> !s.isBlank())
                .toList();
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, errors),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> exception(Exception exception) {
        log.error(exception.getLocalizedMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, List.of("An internal server error occurred.")),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
