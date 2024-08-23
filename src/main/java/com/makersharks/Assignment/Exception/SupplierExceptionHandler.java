package com.makersharks.Assignment.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SupplierExceptionHandler {

    @ExceptionHandler(value = {SupplierNotFoundException.class})
    public ResponseEntity<SupplierException> handleSuppliesNotFoundException
            (SupplierNotFoundException notFoundException)
    {
           SupplierException exception = new SupplierException();
           exception.setMessage(notFoundException.getMessage());
           exception.setErrorCode(HttpStatus.NOT_FOUND.value());
           exception.setStatus(HttpStatus.NOT_FOUND);
           return new ResponseEntity<>(exception, HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<SupplierException> handleGenericExceptions(Exception ex) {
        SupplierException exception = new SupplierException();
        exception.setMessage(ex.getMessage());
        exception.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exception.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exception, HttpStatusCode.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<SupplierException> handleGenericRuntimeExceptions(RuntimeException ex) {
        SupplierException exception = new SupplierException();
        exception.setMessage(ex.getMessage());
        exception.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exception.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exception, HttpStatusCode.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
