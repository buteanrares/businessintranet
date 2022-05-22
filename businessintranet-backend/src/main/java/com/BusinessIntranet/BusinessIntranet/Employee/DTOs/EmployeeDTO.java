package com.BusinessIntranet.BusinessIntranet.Employee.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String jobTitle;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String firstName, String lastName, String phone, String email, String jobTitle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.jobTitle = jobTitle;
    }
}
