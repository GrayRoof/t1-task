package ru.t1.probation.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ValidationException.class})
    public ErrorMessage handleException(ConstraintViolationException exception, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        exception.getConstraintViolations().forEach(error -> {
            String fieldName = error.getPropertyPath().toString();
            String errorMessage = error.getMessage() + " Значение: " + error.getInvalidValue().toString();
            errors.put(fieldName, errorMessage);
        });
        ErrorMessage error = new ErrorMessage(
                new Date(),
                HttpStatus.BAD_REQUEST.value(),
                String.valueOf(errors),
                request.getDescription(false)
        );
        log.warn("Ошибка запроса: {}", errors);
        return error;
    }
}
