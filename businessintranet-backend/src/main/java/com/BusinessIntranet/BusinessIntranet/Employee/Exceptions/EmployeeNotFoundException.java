package com.BusinessIntranet.BusinessIntranet.Employee.Exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

