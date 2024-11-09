package com.woongeya.zoing.global.exception;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(JJoingException.class)
    public ResponseEntity<ErrorResponse> handleDefineException(JJoingException e) {
        log.warn(e.getMessage() + "\n \t {}", e);
        return ResponseEntity.status(e.getStatus())
            .body(new ErrorResponse(e.getStatus().value(), e.getMessage()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleDefineException(MethodArgumentNotValidException e) {
        log.warn(e.getMessage() + "\n \t {}", e);

        String message;

        if (e.getFieldError() == null) {
            message = "";
        } else {
            message = e.getFieldError().getDefaultMessage();
        }

        return new ErrorResponse(400, message);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleDefineException(Exception e) {
        log.error(e.getMessage() + "\n \t {}", e);
        return new ErrorResponse(500, "서버에서 알 수 없는 에러가 발생했습니다.");
    }
}
