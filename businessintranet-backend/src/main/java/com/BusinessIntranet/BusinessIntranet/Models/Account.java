package com.BusinessIntranet.BusinessIntranet.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "account")
    @JsonIgnore
    private Employee employee;


    public Account() {
    }

    public Account(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
