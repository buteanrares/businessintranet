package com.BusinessIntranet.BusinessIntranet.Exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

