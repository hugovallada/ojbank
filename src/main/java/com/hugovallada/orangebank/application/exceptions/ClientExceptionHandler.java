package com.hugovallada.orangebank.application.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ClientExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> handleEntityAlreadyExists(EntityExistsException exception) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, exception.getMessage(), Collections.singletonList(exception.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var errors = new ArrayList<String>();
        exception.getBindingResult().getFieldErrors()
                .forEach(fieldError -> {
                    errors.add("Field " + fieldError.getField().toUpperCase() + " : " + fieldError.getDefaultMessage());
                });
        exception.getBindingResult().getGlobalErrors()
                .forEach(globalError -> {
                    errors.add("Object " + globalError.getObjectName() + " : " + globalError.getDefaultMessage());
                });

        return buildResponseEntity(HttpStatus.BAD_REQUEST, "Informed argument(s) validation error(s)", errors);

    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message, List<String> errors) {
        var apiError = ApiError.builder()
                .code(status.value())
                .status(status.getReasonPhrase())
                .message(message)
                .errors(errors)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(status).body(apiError);
    }
}
