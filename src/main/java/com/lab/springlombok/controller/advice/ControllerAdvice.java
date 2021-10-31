package com.lab.springlombok.controller.advice;

import com.lab.springlombok.exceptions.EntityNotFoundException;
import com.lab.springlombok.exceptions.ExceptionsBag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public final Object handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final Object handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){
        Set<String> violations = ex.getConstraintViolations()
                .stream()
                .map(c -> c.getPropertyPath() + " " + c.getMessage())
                .collect(Collectors.toSet());
        return new ResponseEntity<>(violations, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExceptionsBag.class)
    public final Object handleEntityNotFoundException(ExceptionsBag ex, WebRequest request){
        Set<String> exceptions = ex
                .getExceptions()
                .stream()
                .map(EntityNotFoundException::getMessage)
                .collect(Collectors.toSet());
        ex.clear();
        return new ResponseEntity<>(exceptions, HttpStatus.NOT_FOUND);
    }

}
