package com.makersharks.Assignment.Exception;

import org.springframework.http.HttpStatus;

public class SupplierException {
    private String message;
    private int errorcode;
    private HttpStatus status;

    public SupplierException(){}

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorcode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorCode(int errorCode) {
        this.errorcode = errorCode;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
